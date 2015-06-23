// Package jsonoutput is responsible for storing the result of a form in a JSON
// file from the runtime. It fulfills package frontend interface, therefore
// from package interpreter perspective, this is just another interface.
package jsonoutput

import (
	"encoding/json"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/utils"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

type output struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend
	stream  io.Writer
}

// Write takes in a pair of channels for the interpreter, a writer stream and
// writes JSON output.
func Write(pipes *plumbing.Pipes, stream io.Writer) {
	output := &output{
		receive: pipes.FromInterpreter(),
		send:    pipes.ToInterpreter(),
		stream:  stream,
	}
	output.write()
}

func (o *output) write() {
	utils.OutputHandshake(o.receive, o.send)
	o.writeLines()
}

func (o *output) writeLines() {
	enc := json.NewEncoder(o.stream)
	var lines []map[string]string

commLoop:
	for {
		select {
		case r := <-o.receive:
			switch r.Type {
			case plumbing.UpdateQuestion:
				row := map[string]string{
					"question": r.Identifier,
					"label":    r.Label,
					"value":    r.Value,
				}
				lines = append(lines, row)
			case plumbing.Flush:
				enc.Encode(lines)
				break commLoop
			}
		}
	}

}
