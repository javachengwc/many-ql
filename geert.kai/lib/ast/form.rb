require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class Form
      include Visitable

      attr_reader :name, :statements

      def initialize(name, statements)
        @name = name
        @statements = statements
      end
    end
  end
end