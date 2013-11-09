package com.flagleader.repository.export;

import com.flagleader.export.IExportField;
import com.flagleader.repository.IElement;

public abstract interface IPageField extends IExportField, IElement
{
  public static final String NOTDISPLAY = "notdisplay";
  public static final String HIDDEN = "hidden";
  public static final String STATICTEXT = "label";
  public static final String EMAIL = "email";
  public static final String URL = "url";
  public static final String LINKPRIMARY = "linkprimary";
  public static final String LINKFOREIGN = "linkforeign";
  public static final String TABLE = "table";
  public static final String COOKIEOUT = "tocookie";
  public static final String SESSIONOUT = "tosession";
  public static final String TEXTINPUT = "text";
  public static final String BIGTEXTINPUT = "bigtext";
  public static final String DATEINPUT = "datetext";
  public static final String DATETIMEINPUT = "monthtext";
  public static final String FILEINPUT = "fileinput";
  public static final String NUMBERINPUT = "numbertext";
  public static final String EMAILINPUT = "emailtext";
  public static final String PASSWORDINPUT = "passwordtext";
  public static final String RADIOINPUT = "radio";
  public static final String CHOICEINPUT = "select";
  public static final String CHOICEBYFOREIGN = "fromforeign";
  public static final String CHECKBOXINPUT = "checkbox";
  public static final String CHECKBOXGROUP = "checkboxgroup";
  public static final String COKKIEINPUT = "fromcookie";
  public static final String SESSIONINPUT = "fromsession";
  public static final String COMMONFIELD = "inout";
  public static final String INPUTFIELD = "input";
  public static final String OUTPUTFIELD = "output";
  public static final String SUCCESSFIELD = "success";
  public static final String NOINPUTFIELD = "noput";
  public static final String NOPUT = "noput";
  public static final String NOACTION = "noaction";
  public static final String ERRORFIELD = "error";
  public static final String STRING = "string";
  public static final String NOTTEST = "nottest";
  public static final String EMPTY = "empty";
  public static final String DEFAULTVALUE = "defaultvalue";
  public static final String RESULTVALUE = "resultvalue";
  public static final String READONLY = "readonly";
  public static final String REQUEST = "request";
  public static final String NULL = "null";
  public static final String NOTNULL = "notnull";

  public abstract String getVariableName();

  public abstract String getDisplayName();

  public abstract String getInputType();

  public abstract String getResultType();

  public abstract boolean isEmptyProp(String paramString);

  public abstract boolean isPropValue(String paramString1, String paramString2);

  public abstract boolean isPropValueNoCase(String paramString1, String paramString2);

  public abstract String getPropertyValue(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.IPageField
 * JD-Core Version:    0.6.0
 */