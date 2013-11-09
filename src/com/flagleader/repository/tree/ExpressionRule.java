package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.lang.expression.l;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.util.StringUtil;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExpressionRule extends AbstractRuleTree
  implements IDebugNode, IRule, IRuleContainer, IRuleTree, am
{
  public static final String NAME = "ExpressionRule";
  public static final String DISPLAYNAME = getLocalString("ExpressionRule.text");
  public static final String COMMNAME = getLocalString("ExpressionRule.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("ExpressionRule", DISPLAYNAME, DISPLAYNAME);
  private String expression = "";
  private l rules = null;
  private String errorMsg = "";
  private boolean editTable = false;
  private int exceptionType = 1;
  public static final int NOTCATCH = 0;
  public static final int THROWNEW = 1;
  public static final int THROWINCLUDE = 2;
  public static final int STOPTHROW = 3;
  private int line = 0;

  public ExpressionRule()
  {
  }

  public ExpressionRule(ExpressionRule paramExpressionRule)
  {
    super(paramExpressionRule);
    this.expression = paramExpressionRule.expression;
    this.editTable = paramExpressionRule.editTable;
  }

  public ExpressionRule(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExpressionRule(this);
  }

  public String getName()
  {
    return "ExpressionRule";
  }

  public IElement deepClone()
  {
    return new ExpressionRule(this);
  }

  public String getExpression()
  {
    return this.expression;
  }

  public void setExpression(String paramString)
  {
    this.expression = paramString;
    this.rules = null;
  }

  public Envionment getEnvionment()
  {
    if ((getParent() != null) && ((getParent() instanceof RuleSet)))
      return ((RuleSet)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleSetFlow)))
      return ((RuleSetFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleTreeFlow)))
      return ((RuleTreeFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RulePoolFlow)))
      return ((RulePoolFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RulePackage)))
      return ((RulePackage)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return (Envionment)getParent();
    if ((getParent() != null) && ((getParent() instanceof RuleHistory)))
      return ((RuleHistory)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof PackageHistory)))
      return ((PackageHistory)getParent()).getEnvionment();
    return super.getEnvionment();
  }

  public boolean isEmpty()
  {
    return StringUtil.isEmpty(this.expression);
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    return false;
  }

  public boolean addVariableInit(IVariableObject paramIVariableObject)
  {
    return false;
  }

  public boolean clearDebug()
  {
    int i = 0;
    return i;
  }

  public String toString()
  {
    if (getParent() != null)
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public String getInfo()
  {
    return this.expression;
  }

  protected String d()
  {
    return this.expression;
  }

  public Map getRelateObjectMap(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    try
    {
      List localList = getRules().a(new ArrayList());
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof IRuleObject))
          continue;
        ((IRuleObject)localList.get(i)).findRelateObject(paramMap);
      }
    }
    catch (Exception localException)
    {
    }
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    try
    {
      List localList = getRules().a(new ArrayList());
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof IRuleObject))
          continue;
        ((IRuleObject)localList.get(i)).findAssignObject(paramMap, paramBoolean);
      }
    }
    catch (Exception localException)
    {
    }
    return paramMap;
  }

  public boolean isEditTable()
  {
    return this.editTable;
  }

  public void setEditTable(boolean paramBoolean)
  {
    this.editTable = paramBoolean;
  }

  public void compareExcelSheet(Sheet paramSheet)
  {
  }

  public void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle)
  {
    this.line = 0;
    Row localRow = paramSheet.createRow(this.line++);
    localRow.createCell(1).setCellValue(this.expression);
    localRow.createCell(0).setCellStyle(paramCellStyle);
    localRow.getCell(1).setCellStyle(paramCellStyle);
  }

  public String getText(ILangToken paramILangToken)
  {
    String str = paramILangToken.getText();
    str = StringUtil.replace("\r", "", str);
    if (str.endsWith("\n"))
      return str.substring(0, str.length() - "\n".length());
    return str;
  }

  public void loadFromSheet(Sheet paramSheet)
  {
    updateViewer();
  }

  public void loadFieldFromExcel(String paramString)
  {
    Object localObject = null;
    if (paramString.endsWith(".xls"))
      localObject = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramString)));
    else
      localObject = new XSSFWorkbook(paramString);
    Sheet localSheet = ((Workbook)localObject).getSheetAt(0);
    loadFromSheet(localSheet);
  }

  public void changeText()
  {
    this.rules = null;
    super.setModified(true);
  }

  public void setModified(boolean paramBoolean)
  {
    if (!paramBoolean)
      super.setModified(paramBoolean);
  }

  public int getRuleTableCount()
  {
    return 1;
  }

  public l getRules()
  {
    if (this.rules == null)
      this.rules = new l(new StatementSystem(this), this.expression);
    return this.rules;
  }

  public void setRules(l paraml)
  {
    this.rules = paraml;
  }

  public int getExceptionType()
  {
    return this.exceptionType;
  }

  public void setExceptionType(int paramInt)
  {
    this.exceptionType = paramInt;
  }

  public String getErrorMsg()
  {
    return this.errorMsg;
  }

  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ExpressionRule
 * JD-Core Version:    0.6.0
 */