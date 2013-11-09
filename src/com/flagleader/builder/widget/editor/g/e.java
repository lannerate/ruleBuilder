package com.flagleader.builder.widget.editor.g;

import com.flagleader.builder.widget.editor.c.a;
import com.flagleader.manager.c.d;
import com.flagleader.util.ArrayIterator;
import com.flagleader.util.ListIterator;
import java.util.HashMap;
import java.util.Iterator;

public class e extends d
{
  public static final String[] a = { "exportModel", "variables", "elements", "element", "inputVariables", "outputVariables", "errorVariables", "variableName", "variable", "field", "writer", "successVariables", "variableMap", "displayMap", "distinctVars" };
  public static final HashMap b = new HashMap(a.length);
  public static final String[] c;

  static
  {
    b.put("exportModel", "com.flagleader.repository.export.IPage");
    b.put("element", "com.flagleader.export.IExportElement");
    b.put("variableName", "java.lang.String");
    b.put("variable", "com.flagleader.export.IExportField");
    b.put("field", "com.flagleader.export.IExportField");
    b.put("temp_variable", "com.flagleader.export.IExportField");
    b.put("variableMap", "java.util.HashMap");
    b.put("displayMap", "java.util.HashMap");
    b.put("variables[", "com.flagleader.export.IExportField");
    b.put("elements[", "com.flagleader.export.IExportElement");
    b.put("inputVariables[", "com.flagleader.export.IExportField");
    b.put("outputVariables[", "com.flagleader.export.IExportField");
    b.put("errorVariables[", "com.flagleader.export.IExportField");
    b.put("successVariables[", "com.flagleader.export.IExportField");
    b.put("distinctVars[", "com.flagleader.export.IExportField");
    b.put("writer", "java.io.PrintWriter");
    c = new String[] { "getJavaType", "getElementName", "getElementType", "getChildFields", "getAdvanceProperties", "getPropertyValue", "getProperty", "getKeysPre", "isEmptyProp", "getDisplayName", "getVariableName", "getValueType", "getLen", "isUnNull", "getInputType", "getResultType", "getListPos", "getDefaultValue", "getStatType", "messgeToHtml", "messgeToJsp", "getInputValueType", "getShowValue", "getNullType", "getValueFrom", "getTitle", "isPropValue", "isPropValueNoCase", "length", "substring", "equalsIgnoreCase", "getJavaTypeName", "getInputFieldCount", "isListList", "isList", "isNumber", "isBoolean", "isChar", "isString", "isDate", "isDateTime", "isTime", "isShort", "isInteger", "isLong", "isFloat", "isDouble", "getExeRulePackageName", "print", "println", "isInclude", "isProp", "toDefine", "toJsp", "toHtml", "printResource", "formatProp", "addJS", "addJSSrc", "temp_variable" };
  }

  public Iterator a(String paramString)
  {
    try
    {
      String[] arrayOfString = b(paramString);
      String str = c(arrayOfString[0]);
      if (arrayOfString.length > 1)
        for (int i = 0; i < arrayOfString.length - 1; i++)
          str = a.a().a(str, arrayOfString[(i + 1)]);
      if (str.length() > 0)
        return new ListIterator(a.a().a(str));
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected String[] b(String paramString)
  {
    String[] arrayOfString = paramString.split("[.]");
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString[i] = c(arrayOfString[i]);
    return arrayOfString;
  }

  protected String c(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf("[") > 0)
      str = (String)b.get(paramString.substring(0, paramString.indexOf("[") + 1));
    else
      str = (String)b.get(paramString);
    if (str == null)
      str = paramString;
    return str;
  }

  public Iterator a()
  {
    return new ArrayIterator(a);
  }

  public Iterator b()
  {
    return new ArrayIterator(c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.g.e
 * JD-Core Version:    0.6.0
 */