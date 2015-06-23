package ql.gui

import types.Label

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.{JFXApp, Platform}
import scalafx.geometry.Insets
import scalafx.scene.control.ScrollPane
import scalafx.scene.control.ScrollPane.ScrollBarPolicy
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.{Node, Scene}
import scalafx.stage.WindowEvent

class FormGUI(label: Label, nodes: List[Node]) extends JFXApp {

  val Width: Int = 300
  val Height: Int = 450
  val Padding: Int = 10

  val gridPane = new GridPane {
    padding = Insets(Padding)
    for ((node, i) <- nodes.zipWithIndex) {
      add(node, 1, i + 1)
    }
  }

  val scrollPane = new ScrollPane {
    content = gridPane
    hbarPolicy = ScrollBarPolicy.AS_NEEDED
    vbarPolicy = ScrollBarPolicy.AS_NEEDED
  }

  stage = new PrimaryStage {
    title.value = label
    scene = new Scene(scrollPane, Width, Height, Color.LIGHTGRAY)
    onCloseRequest = (event: WindowEvent) => { Platform.exit(); sys.exit(0) }
  }
}
