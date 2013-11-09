package com.flagleader.builder.test;

import com.flagleader.manager.d.c;
import java.io.PrintStream;

public class MenuHtml
{
  protected StringBuffer a = new StringBuffer();
  protected boolean b = false;
  private int c = 0;

  public void a(String paramString)
  {
    for (int i = 0; i < this.c; i++)
      this.a.append("\t");
    this.a.append(paramString);
  }

  public void a()
  {
    this.a.setLength(0);
  }

  public String b()
  {
    c("RuleDBProject");
    c("RuleProject");
    c("RuleGroup");
    c("RulePackage");
    c("RuleSet");
    c("RuleSetFlow");
    c("RuleTreeFlow");
    c("RulePoolFlow");
    c("Rule");
    c("Envionment");
    c("xmlNode");
    c("CustomFunction");
    c("TestCaseLib");
    c("TestCase");
    c("ExportModel");
    c("AjaxPage");
    c("DBModel");
    c("TableModel");
    c("selectTable");
    c("ProcedureModel");
    c("SheetTable");
    c("CustomSql");
    c("DecisionRule");
    c("DecisionMultiRule");
    c("ExpressionRule");
    c("DecisionRelateRule");
    c("RuleMirror");
    c("EnumTable");
    c("ExcelBookModel");
    c("ExcelSheetModel");
    c("ExcelTableSheetModel");
    c("ExcelXYSheetModel");
    c("SoapService");
    c("TreeValueNode");
    c("ClassContainer");
    c("InterfaceContainer");
    c("BOContainerGroup");
    c("SheetMap");
    a("SheetTable", "SheetTable2");
    a("TreeValueNode", "TreeValueNode2");
    a("xmlNode", "firstxml");
    a("xmlNode", "xmlNode2");
    return this.a.toString();
  }

  private void b(String paramString)
  {
    this.c += 1;
    Object localObject;
    if (c.e(paramString + ".menu") != null)
    {
      a(c.a(paramString, paramString) + "\n");
      localObject = c.e(paramString + ".menu");
      for (int i = 0; i < localObject.length; i++)
        if (localObject[i].trim().equals("-"))
          a("-\n");
        else
          b(localObject[i]);
    }
    else if (paramString.trim().equals("-"))
    {
      a("-\n");
    }
    else
    {
      localObject = null;
      if (c.c(paramString + ".listener") != null)
        localObject = c.c(paramString + ".listener");
      if (localObject != null)
        a(c.a(paramString, paramString) + "\n");
    }
    this.c -= 1;
  }

  private void c(String paramString)
  {
    String[] arrayOfString = c.e(paramString + ".popupMenu");
    if (arrayOfString != null)
    {
      a(paramString + "\n");
      for (int i = 0; i < arrayOfString.length; i++)
        b(arrayOfString[i]);
      a("\n");
    }
  }

  private void a(String paramString1, String paramString2)
  {
    String[] arrayOfString = c.e(paramString1 + ".popupMenu");
    if (arrayOfString != null)
    {
      a(paramString2 + "\n");
      for (int i = 0; i < arrayOfString.length; i++)
        b(arrayOfString[i]);
      a("\n");
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    c.a("prof");
    System.out.println(new MenuHtml().b());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.test.MenuHtml
 * JD-Core Version:    0.6.0
 */