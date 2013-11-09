package com.flagleader.repository.tree;

import com.flagleader.engine.MessageUtil;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.e.m;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.lang.expression.i;
import com.flagleader.repository.lang.expression.j;
import com.flagleader.repository.lang.expression.w;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.RuleEnterToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.e;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Rule extends AbstractRuleTree
  implements IDebugNode, IRule, IRuleTree, am
{
  public static final String NAME = "Rule";
  public static final String DISPLAYNAME = getLocalString("Rule.text");
  public static final String COMMNAME = getLocalString("Rule.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("Rule", DISPLAYNAME, DISPLAYNAME);
  private String errorMsg = "";
  private int elseifNum = 0;
  private boolean supportElse = false;
  private boolean supportCatch = false;
  private boolean supportInit = false;
  private boolean supportEnter = false;
  private int exceptionType = 1;
  public static final int NOTCATCH = 0;
  public static final int THROWNEW = 1;
  public static final int THROWINCLUDE = 2;
  public static final int STOPTHROW = 3;
  private boolean editTable = false;
  private List ruleTableInfos = null;
  private int line = 0;

  public Rule()
  {
  }

  public Rule(Rule paramRule)
  {
    super(paramRule);
    this.errorMsg = paramRule.errorMsg;
    this.exceptionType = paramRule.exceptionType;
    this.supportElse = paramRule.supportElse;
    this.supportInit = paramRule.supportInit;
    this.supportCatch = paramRule.supportCatch;
    this.supportEnter = paramRule.supportEnter;
    this.editTable = paramRule.editTable;
  }

  public Rule(String paramString)
  {
    super(paramString);
  }

  public RuleToken getRuleElementToken()
  {
    if (!hasChildren())
    {
      RuleToken localRuleToken = new RuleToken();
      addChildElement(localRuleToken);
    }
    return (RuleToken)getChildrenIterator().next();
  }

  public void setRuleElementToken(RuleToken paramRuleToken)
  {
    getRuleElementToken().dispose();
    addChildElement(paramRuleToken);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRule(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    super.addChildElement(paramIElement);
  }

  public String getName()
  {
    return "Rule";
  }

  public IElement deepClone()
  {
    return new Rule(this);
  }

  public String getErrorMsg()
  {
    return this.errorMsg;
  }

  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }

  public Envionment getEnvionment()
  {
    if ((getParent() != null) && ((getParent() instanceof RuleSet)))
      return ((RuleSet)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleSetFlow)))
      return ((RuleSetFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleTreeFlow)))
      return ((RuleTreeFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleTreeFlow)))
      return ((RuleTreeFlow)getParent()).getEnvionment();
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

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof RuleToken);
  }

  public boolean isEmpty()
  {
    if (getRuleElementToken().getWhenCondition().getConditions().hasNext())
      return false;
    return !getRuleElementToken().getThenActions().getActions().hasNext();
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    return getRuleElementToken().getThenActions().addVariableDebug(paramIVariableObject);
  }

  public boolean addVariableInit(IVariableObject paramIVariableObject)
  {
    return getRuleElementToken().getThenActions().addVariableInit(paramIVariableObject);
  }

  public boolean clearDebug()
  {
    int i = 0;
    if (getRuleElementToken().getThenActions().clearDebug())
      i = 1;
    if (getRuleElementToken().getInitActions().clearDebug())
      i = 1;
    if (getRuleElementToken().getCatchActions().clearDebug())
      i = 1;
    return i;
  }

  public int getExceptionType()
  {
    return this.exceptionType;
  }

  public void setExceptionType(int paramInt)
  {
    this.exceptionType = paramInt;
  }

  public String toString()
  {
    if (getParent() != null)
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public boolean isSupportElse()
  {
    return this.supportElse;
  }

  public void setSupportElse(boolean paramBoolean)
  {
    this.supportElse = paramBoolean;
  }

  public boolean isSupportCatch()
  {
    return this.supportCatch;
  }

  public void setSupportCatch(boolean paramBoolean)
  {
    this.supportCatch = paramBoolean;
  }

  public boolean isSupportInit()
  {
    return this.supportInit;
  }

  public void setSupportInit(boolean paramBoolean)
  {
    this.supportInit = paramBoolean;
  }

  public String getInfo()
  {
    return new m().b(getRuleElementToken().getWhenCondition());
  }

  protected String d()
  {
    return new m().b(getRuleElementToken());
  }

  public int getElseifNum()
  {
    return getRuleElementToken().getElseIfTokens().size();
  }

  public void setElseifNum(int paramInt)
  {
    this.elseifNum = paramInt;
  }

  public Map getRelateObjectMap(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    getRuleElementToken().findRelateObject(paramMap);
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    getRuleElementToken().findAssignObject(paramMap, paramBoolean);
    return paramMap;
  }

  public boolean isSupportEnter()
  {
    return this.supportEnter;
  }

  public void setSupportEnter(boolean paramBoolean)
  {
    this.supportEnter = paramBoolean;
  }

  public String getFirstConditionMember()
  {
    IMultiConditionToken localIMultiConditionToken = getRuleElementToken().getWhenCondition();
    List localList = localIMultiConditionToken.getConditionList();
    String str = "";
    if ((localList.size() > 0) && (((IConditionToken)localList.get(0)).getFirstValue() != null))
    {
      str = ((IConditionToken)localList.get(0)).getFirstValue().getDisplayName();
      if ((localList.size() > 1) && (((IConditionToken)localList.get(1)).getFirstValue() != null) && (!((IConditionToken)localList.get(1)).getFirstValue().getDisplayName().equals(str)))
        str = "";
    }
    return str;
  }

  public String getFirstActionMember()
  {
    IMultiActionToken localIMultiActionToken = getRuleElementToken().getThenActions();
    Iterator localIterator = localIMultiActionToken.getActions();
    String str = "";
    if (localIterator.hasNext())
    {
      IStatementContainerToken localIStatementContainerToken = (IStatementContainerToken)localIterator.next();
      if ((!localIterator.hasNext()) && ((localIStatementContainerToken.getStatement() instanceof AssignToken)) && (((AssignToken)localIStatementContainerToken.getStatement()).getFirstValue() != null))
        str = ((AssignToken)localIStatementContainerToken.getStatement()).getFirstValue().getDisplayName();
    }
    return str;
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
    List localList = getRuleElementToken().getRuleTableInfos();
    CellStyle localCellStyle = a(paramSheet.getWorkbook());
    FormulaEvaluator localFormulaEvaluator = paramSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
    this.line = 0;
    Row localRow = paramSheet.getRow(this.line++);
    a(localRow.getCell(1), u.a("tv_condition"), localCellStyle, localFormulaEvaluator);
    a(localRow.getCell(2), u.a("tv_action"), localCellStyle, localFormulaEvaluator);
    for (int i = 0; i < localList.size(); i++)
    {
      localRow = paramSheet.getRow(this.line++);
      e locale = (e)localList.get(i);
      a(localRow.getCell(0), locale.a(), localCellStyle, localFormulaEvaluator);
      if (locale.e() == 0)
      {
        a(localRow.getCell(1), getText(((RuleToken)locale.f()).getWhenCondition()), localCellStyle, localFormulaEvaluator);
        a(localRow.getCell(2), getText(((RuleToken)locale.f()).getThenActions()), localCellStyle, localFormulaEvaluator);
      }
      else if ((locale.e() == 4) || (locale.e() == 3) || (locale.e() == 5))
      {
        a(localRow.getCell(2), getText((IMultiActionToken)locale.f()), localCellStyle, localFormulaEvaluator);
      }
      else if (locale.e() == 2)
      {
        a(localRow.getCell(1), getText(((RuleEnterToken)locale.f()).getWhenCondition()), localCellStyle, localFormulaEvaluator);
      }
      else
      {
        if (locale.e() != 1)
          continue;
        a(localRow.getCell(1), getText(((ElseIfRuleToken)locale.f()).getWhenCondition()), localCellStyle, localFormulaEvaluator);
        a(localRow.getCell(2), getText(((ElseIfRuleToken)locale.f()).getThenActions()), localCellStyle, localFormulaEvaluator);
      }
    }
  }

  public void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle)
  {
    List localList = getRuleElementToken().getRuleTableInfos();
    this.line = 0;
    Row localRow = paramSheet.createRow(this.line++);
    localRow.createCell(1).setCellValue(u.a("tv_condition"));
    localRow.createCell(2).setCellValue(u.a("tv_action"));
    localRow.createCell(0).setCellStyle(paramCellStyle);
    localRow.getCell(1).setCellStyle(paramCellStyle);
    localRow.getCell(2).setCellStyle(paramCellStyle);
    for (int i = 0; i < localList.size(); i++)
    {
      localRow = paramSheet.createRow(this.line++);
      e locale = (e)localList.get(i);
      localRow.createCell(0).setCellValue(locale.a());
      localRow.getCell(0).setCellStyle(paramCellStyle);
      if (locale.e() == 0)
      {
        localRow.createCell(1).setCellValue(getText(((RuleToken)locale.f()).getWhenCondition()));
        localRow.createCell(2).setCellValue(getText(((RuleToken)locale.f()).getThenActions()));
        localRow.getCell(1).setCellStyle(paramCellStyle);
        localRow.getCell(2).setCellStyle(paramCellStyle);
      }
      else if ((locale.e() == 4) || (locale.e() == 3) || (locale.e() == 5))
      {
        localRow.createCell(1);
        localRow.createCell(2).setCellValue(getText((IMultiActionToken)locale.f()));
        localRow.getCell(1).setCellStyle(paramCellStyle);
        localRow.getCell(2).setCellStyle(paramCellStyle);
      }
      else if (locale.e() == 2)
      {
        localRow.createCell(1).setCellValue(getText(((RuleEnterToken)locale.f()).getWhenCondition()));
        localRow.createCell(2);
        localRow.getCell(1).setCellStyle(paramCellStyle);
        localRow.getCell(2).setCellStyle(paramCellStyle);
      }
      else
      {
        if (locale.e() != 1)
          continue;
        localRow.createCell(1).setCellValue(getText(((ElseIfRuleToken)locale.f()).getWhenCondition()));
        localRow.createCell(2).setCellValue(getText(((ElseIfRuleToken)locale.f()).getThenActions()));
        localRow.getCell(1).setCellStyle(paramCellStyle);
        localRow.getCell(2).setCellStyle(paramCellStyle);
      }
    }
    paramSheet.setColumnWidth(0, 3000);
    for (i = 1; i < 3; i = (short)(i + 1))
      paramSheet.autoSizeColumn(i);
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
    FormulaEvaluator localFormulaEvaluator = paramSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
    RuleToken localRuleToken = new RuleToken();
    localRuleToken.setParent(this);
    StatementSystem localStatementSystem = new StatementSystem(this);
    for (int i = 1; i < 32767; i++)
    {
      Row localRow = paramSheet.getRow(i);
      if (localRow == null)
        break;
      String str1 = a(localRow.getCell(0), localFormulaEvaluator);
      String str2 = a(localRow.getCell(1), localFormulaEvaluator);
      str2 = StringUtil.replace("\r", "", str2);
      if ((StringUtil.isEmpty(str1)) && (StringUtil.isEmpty(str2)))
        break;
      Object localObject1;
      Object localObject2;
      int k;
      Object localObject4;
      Object localObject5;
      ConditionToken localConditionToken3;
      if (u.a("tv_enter").equalsIgnoreCase(str1))
      {
        localObject1 = new RuleEnterToken();
        localRuleToken.addChildElement((IElement)localObject1);
        localObject2 = localStatementSystem.d(str2);
        for (k = 0; k < localObject2.length; k++)
        {
          localObject4 = new ConditionToken();
          ((ConditionToken)localObject4).init();
          ((RuleEnterToken)localObject1).getWhenCondition().addChildElement((IElement)localObject4);
          localObject5 = localObject2[k].b();
          if (((ArrayList)localObject5).size() > 0)
            ((w)((ArrayList)localObject5).get(0)).a((ConditionToken)localObject4);
          if (((ArrayList)localObject5).size() <= 1)
            continue;
          Object localObject6 = localObject4;
          for (int i3 = 1; i3 < ((ArrayList)localObject5).size(); i3++)
          {
            localConditionToken3 = new ConditionToken();
            localConditionToken3.init();
            localObject6.addChildElement(localConditionToken3);
            ((w)((ArrayList)localObject5).get(i3)).a(localConditionToken3);
          }
        }
        if ((localObject2.length <= 0) || (isSupportEnter()))
          continue;
        setSupportEnter(true);
      }
      else if (u.a("tv_init").equalsIgnoreCase(str1))
      {
        localObject1 = localRuleToken.getInitActions();
        localObject2 = localStatementSystem.f(a(localRow.getCell(2), localFormulaEvaluator));
        for (k = 0; k < localObject2.length; k++)
        {
          localObject4 = new StatementContainerToken();
          ((IMultiActionToken)localObject1).addChildElement((IElement)localObject4);
          localObject2[k].a((StatementContainerToken)localObject4);
        }
        if ((localObject2.length <= 0) || (isSupportInit()))
          continue;
        setSupportInit(true);
      }
      else
      {
        Object localObject3;
        int m;
        if (u.a("tv_ifthen").equalsIgnoreCase(str1))
        {
          localObject1 = localStatementSystem.d(str2);
          for (int j = 0; j < localObject1.length; j++)
          {
            ConditionToken localConditionToken1 = new ConditionToken();
            localConditionToken1.init();
            localRuleToken.getWhenCondition().addChildElement(localConditionToken1);
            localObject4 = localObject1[j].b();
            if (((ArrayList)localObject4).size() > 0)
              ((w)((ArrayList)localObject4).get(0)).a(localConditionToken1);
            if (((ArrayList)localObject4).size() <= 1)
              continue;
            localObject5 = localConditionToken1;
            for (int i2 = 1; i2 < ((ArrayList)localObject4).size(); i2++)
            {
              ConditionToken localConditionToken2 = new ConditionToken();
              localConditionToken2.init();
              ((ConditionToken)localObject5).addChildElement(localConditionToken2);
              ((w)((ArrayList)localObject4).get(i2)).a(localConditionToken2);
            }
          }
          localObject3 = localStatementSystem.f(a(localRow.getCell(2), localFormulaEvaluator));
          for (m = 0; m < localObject3.length; m++)
          {
            localObject4 = new StatementContainerToken();
            localRuleToken.getThenActions().addChildElement((IElement)localObject4);
            localObject3[m].a((StatementContainerToken)localObject4);
          }
        }
        else if (u.a("tv_elseif").equalsIgnoreCase(str1))
        {
          localObject1 = new ElseIfRuleToken();
          localRuleToken.addChildElement((IElement)localObject1);
          localObject3 = localStatementSystem.d(str2);
          for (m = 0; m < localObject3.length; m++)
          {
            localObject4 = new ConditionToken();
            ((ConditionToken)localObject4).init();
            ((ElseIfRuleToken)localObject1).getWhenCondition().addChildElement((IElement)localObject4);
            localObject5 = localObject3[m].b();
            if (((ArrayList)localObject5).size() > 0)
              ((w)((ArrayList)localObject5).get(0)).a((ConditionToken)localObject4);
            if (((ArrayList)localObject5).size() <= 1)
              continue;
            Object localObject7 = localObject4;
            for (int i4 = 1; i4 < ((ArrayList)localObject5).size(); i4++)
            {
              localConditionToken3 = new ConditionToken();
              localConditionToken3.init();
              localObject7.addChildElement(localConditionToken3);
              ((w)((ArrayList)localObject5).get(i4)).a(localConditionToken3);
            }
          }
          i[] arrayOfi = localStatementSystem.f(a(localRow.getCell(2), localFormulaEvaluator));
          for (int i1 = 0; i1 < arrayOfi.length; i1++)
          {
            localObject5 = new StatementContainerToken();
            ((ElseIfRuleToken)localObject1).getThenActions().addChildElement((IElement)localObject5);
            arrayOfi[i1].a((StatementContainerToken)localObject5);
          }
        }
        else
        {
          int n;
          StatementContainerToken localStatementContainerToken;
          if (u.a("tv_else").equalsIgnoreCase(str1))
          {
            localObject1 = localRuleToken.getElseActions();
            localObject3 = localStatementSystem.f(a(localRow.getCell(2), localFormulaEvaluator));
            for (n = 0; n < localObject3.length; n++)
            {
              localStatementContainerToken = new StatementContainerToken();
              ((IMultiActionToken)localObject1).addChildElement(localStatementContainerToken);
              localObject3[n].a(localStatementContainerToken);
            }
            if ((localObject3.length <= 0) || (isSupportElse()))
              continue;
            setSupportElse(true);
          }
          else
          {
            if (!u.a("tv_catch").equalsIgnoreCase(str1))
              continue;
            localObject1 = localRuleToken.getCatchActions();
            localObject3 = localStatementSystem.f(a(localRow.getCell(2), localFormulaEvaluator));
            for (n = 0; n < localObject3.length; n++)
            {
              localStatementContainerToken = new StatementContainerToken();
              ((IMultiActionToken)localObject1).addChildElement(localStatementContainerToken);
              localObject3[n].a(localStatementContainerToken);
            }
            if ((localObject3.length <= 0) || (isSupportCatch()))
              continue;
            setSupportCatch(true);
          }
        }
      }
    }
    getRuleElementToken().replaceAllChildren(localRuleToken.getChildrenList());
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

  public List getRuleTableInfos()
  {
    if (this.ruleTableInfos == null)
      this.ruleTableInfos = getRuleElementToken().getRuleTableInfos();
    return this.ruleTableInfos;
  }

  public void setModified(boolean paramBoolean)
  {
    if (paramBoolean)
      this.ruleTableInfos = null;
    super.setModified(paramBoolean);
  }

  public int getRuleTableCount()
  {
    return getRuleTableInfos().size();
  }

  public void exportXsl(String paramString)
  {
    Object localObject = null;
    if (paramString.endsWith(".xls"))
      localObject = new HSSFWorkbook();
    else
      localObject = new XSSFWorkbook();
    b((Workbook)localObject);
    File localFile = new File(paramString);
    if (!localFile.exists())
      localFile.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    ((Workbook)localObject).write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
  }

  private Workbook b(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    Font localFont = paramWorkbook.createFont();
    localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
    localFont.setFontHeightInPoints(12);
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setBorderBottom(1);
    localCellStyle.setBorderLeft(1);
    localCellStyle.setBorderRight(1);
    localCellStyle.setBorderTop(1);
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
    localSheet = paramWorkbook.createSheet(getDisplayName());
    exportExcelSheet(localSheet, localCellStyle);
    return paramWorkbook;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.Rule
 * JD-Core Version:    0.6.0
 */