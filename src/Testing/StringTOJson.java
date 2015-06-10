package Testing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StringTOJson
{
	public static void main(String[] args) throws ParseException
	{
		JSONParser parser = new JSONParser();

		JSONObject o = (JSONObject) parser.parse("(JAVA_SOURCE ANNOTATION_LIST (package Testing) (import (. (. java util) ArrayList)) (import (. (. java util) List)) (class (MODIFIER_LIST public) tester (CLASS_TOP_LEVEL_SCOPE (VAR_DECLARATION (MODIFIER_LIST private) (TYPE int) (VAR_DECLARATOR_LIST (VAR_DECLARATOR age (EXPR 29)))) (VAR_DECLARATION (MODIFIER_LIST private) (TYPE (QUALIFIED_TYPE_IDENT String)) (VAR_DECLARATOR_LIST (VAR_DECLARATOR name (EXPR \"mkyong\")))) (VAR_DECLARATION (MODIFIER_LIST private) (TYPE (QUALIFIED_TYPE_IDENT (List (GENERIC_TYPE_ARG_LIST (TYPE (QUALIFIED_TYPE_IDENT String)))))) (VAR_DECLARATOR_LIST (VAR_DECLARATOR messages (EXPR (STATIC_ARRAY_CREATOR (QUALIFIED_TYPE_IDENT (ArrayList (GENERIC_TYPE_ARG_LIST (TYPE (QUALIFIED_TYPE_IDENT String))))) ARGUMENT_LIST (CLASS_TOP_LEVEL_SCOPE (CLASS_INSTANCE_INITIALIZER (BLOCK_SCOPE (EXPR (METHOD_CALL add (ARGUMENT_LIST (EXPR \"msg 1\")))) (EXPR (METHOD_CALL add (ARGUMENT_LIST (EXPR \"msg 2\")))) (EXPR (METHOD_CALL add (ARGUMENT_LIST (EXPR \"msg 3\")))))))))))) (FUNCTION_METHOD_DECL (MODIFIER_LIST (@ Override) public) (TYPE (QUALIFIED_TYPE_IDENT String)) toString FORMAL_PARAM_LIST (BLOCK_SCOPE (return (EXPR (+ (+ (+ (+ (+ (+ (+ \"User [age=\" age) \", name=\") name) \", \") \"messages=\") messages) \"]\"))))))))");
		System.out.println(o);
	}
}

