package com.flagleader.repository.tree;

import com.flagleader.engine.MessageUtil;
import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.e.m;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectConstructor;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DecisionRule extends AbstractRuleTree
  implements IDecision, IRule, IRuleContainer, IRuleTree, am
{
  public static final String NAME = "DecisionRule";
  public static final String DISPLAYNAME = getLocalString("DecisionRule.text");
  public static final String COMMNAME = getLocalString("DecisionRule.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("DecisionRule", DISPLAYNAME, DISPLAYNAME);
  private String elementUuid = "";
  private String uniqueName = "";
  private int conditionNum = 1;
  private List lineinfos = null;
  int b = 0;
  DecisionRule.DecisionElementSelector g = new DecisionRule.DecisionElementSelector(this);
  protected ArrayList h = null;

  public DecisionRule(DecisionRule paramDecisionRule)
  {
    super(paramDecisionRule);
    this.elementUuid = paramDecisionRule.elementUuid;
    this.uniqueName = paramDecisionRule.uniqueName;
    this.conditionNum = paramDecisionRule.conditionNum;
  }

  public DecisionRule()
  {
  }

  public DecisionRule(String paramString)
  {
    super(paramString);
  }

  public IMultiConditionToken getFirstConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof IMultiConditionToken)) && (((IMultiConditionToken)localList.get(i)).getType() == 1))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken(1);
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public String getSecondMember()
  {
    IMultiConditionToken localIMultiConditionToken = getFirstConditions();
    List localList = localIMultiConditionToken.getConditionList();
    if ((localList.size() > 0) && (((IConditionToken)localList.get(0)).getFirstValue() != null))
      return ((IConditionToken)localList.get(0)).getFirstValue().getDisplayName();
    return "";
  }

  public String getFirstMember(int paramInt)
  {
    Object localObject;
    if (paramInt <= 1)
    {
      localObject = getSecondConditions();
      List localList1 = ((IMultiConditionToken)localObject).getConditionList();
      if ((localList1.size() > 0) && (((IConditionToken)localList1.get(0)).getFirstValue() != null))
        return ((IConditionToken)localList1.get(0)).getFirstValue().getDisplayName();
    }
    else
    {
      localObject = a();
      for (int i = 0; i < ((List)localObject).size(); i++)
      {
        if ((!(((List)localObject).get(i) instanceof DecisionRelateCondition)) || (((DecisionRelateCondition)((List)localObject).get(i)).getConditionPos() != paramInt))
          continue;
        IMultiConditionToken localIMultiConditionToken = ((DecisionRelateCondition)((List)localObject).get(i)).getConditions();
        List localList2 = localIMultiConditionToken.getConditionList();
        if ((localList2.size() > 0) && (((IConditionToken)localList2.get(0)).getFirstValue() != null))
          return ((IConditionToken)localList2.get(0)).getFirstValue().getDisplayName();
      }
    }
    return (String)"";
  }

  public IMultiConditionToken getSecondConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof IMultiConditionToken)) && (((IMultiConditionToken)localList.get(i)).getType() == 2))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken(2);
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public List getNextConditions(IConditionToken paramIConditionToken, int paramInt)
  {
    return getRelateCondition(paramIConditionToken, paramInt).getConditions().getConditionList();
  }

  public DecisionRelateCondition getRelateCondition(IConditionToken paramIConditionToken, int paramInt)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionRelateCondition)) && (((DecisionRelateCondition)localList.get(i)).getConditionUuids().equals(paramIConditionToken.getUuid())))
        return (DecisionRelateCondition)localList.get(i);
    DecisionRelateCondition localDecisionRelateCondition = new DecisionRelateCondition(paramIConditionToken.getUuid(), paramInt + 1);
    super.addChildElement(localDecisionRelateCondition);
    return localDecisionRelateCondition;
  }

  public boolean isValidConditoin(String paramString)
  {
    List localList1 = a();
    for (int i = 0; i < localList1.size(); i++)
    {
      List localList2;
      int j;
      if ((localList1.get(i) instanceof IMultiConditionToken))
      {
        localList2 = ((IMultiConditionToken)localList1.get(i)).getConditionList();
        for (j = 0; j < localList2.size(); j++)
          if (((IConditionToken)localList2.get(j)).getUuid().equals(paramString))
            return true;
      }
      else
      {
        if (!(localList1.get(i) instanceof DecisionRelateCondition))
          continue;
        localList2 = ((DecisionRelateCondition)localList1.get(i)).getConditions().getConditionList();
        for (j = 0; j < localList2.size(); j++)
          if (((IConditionToken)localList2.get(j)).getUuid().equals(paramString))
            return true;
      }
    }
    return false;
  }

  public int guessUuidLength(String paramString)
  {
    for (int i = this.conditionNum; i >= 1; i--)
    {
      int j = paramString.length() / i;
      if ((j == 40) || ((j >= 18) && (j <= 22)))
        return j;
    }
    return paramString.length();
  }

  public boolean isValidElement2(String paramString)
  {
    int i = guessUuidLength(paramString);
    for (int j = 0; j < paramString.length() / i; j++)
    {
      if (paramString.length() < (j + 1) * i)
        return false;
      if (!isValidConditoin(paramString.substring(j * i, (j + 1) * i)))
        return false;
    }
    return true;
  }

  public boolean isValidElement(String paramString)
  {
    int i = guessUuidLength(paramString);
    for (int j = 0; j < this.conditionNum; j++)
    {
      if (paramString.length() < (j + 1) * i)
        break;
      if (!isValidConditoin(paramString.substring(j * i, (j + 1) * i)))
        return false;
    }
    return true;
  }

  public List getLineInfos()
  {
    if (this.lineinfos == null)
    {
      this.lineinfos = new ArrayList();
      List localList1 = getSecondConditions().getConditionList();
      Object localObject;
      for (int i = 0; i < localList1.size(); i++)
      {
        localObject = new ArrayList(1);
        ((List)localObject).add(localList1.get(i));
        a(this.lineinfos, (List)localObject);
      }
      for (i = 0; i < this.lineinfos.size(); i++)
      {
        localObject = (l)this.lineinfos.get(i);
        List localList2 = ((l)localObject).a();
        for (int j = 0; j < localList2.size(); j++)
        {
          IConditionToken localIConditionToken = (IConditionToken)localList2.get(j);
          if (((l)localObject).a(j) <= 0)
            continue;
          ((l)localObject).a(j, a(this.lineinfos, i, j, localIConditionToken));
        }
      }
    }
    return (List)this.lineinfos;
  }

  private int a(List paramList, int paramInt1, int paramInt2, IConditionToken paramIConditionToken)
  {
    int i = 0;
    for (int j = paramInt1; j < paramList.size(); j++)
    {
      l locall = (l)paramList.get(j);
      List localList = locall.a();
      if ((localList.size() <= paramInt2) || (!paramIConditionToken.equals(localList.get(paramInt2))))
        continue;
      i += locall.a(paramInt2);
      locall.a(paramInt2, 0);
    }
    return i;
  }

  private void a(List paramList1, List paramList2)
  {
    if (paramList2.size() < getConditionNum())
    {
      List localList = getNextConditions((IConditionToken)paramList2.get(paramList2.size() - 1), paramList2.size());
      if (localList.size() == 0)
        b(paramList1, paramList2);
      else
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList2.size() + 1);
          localArrayList.addAll(paramList2);
          localArrayList.add(localList.get(i));
          a(paramList1, localArrayList);
        }
    }
    else
    {
      b(paramList1, paramList2);
    }
  }

  private void b(List paramList1, List paramList2)
  {
    paramList1.add(new l(paramList2));
  }

  private void i()
  {
    List localList1 = a();
    for (int i = 0; i < localList1.size(); i++)
    {
      if (!(localList1.get(i) instanceof DecisionValue))
        continue;
      DecisionValue localDecisionValue = (DecisionValue)localList1.get(i);
      if ((localDecisionValue.getConditionUuids().length() != 0) || (localDecisionValue.getDisplayName().length() <= 0))
        continue;
      List localList2 = getLineInfos();
      if (localList2.size() <= localDecisionValue.getY())
        continue;
      List localList3 = ((l)localList2.get(localDecisionValue.getY())).a();
      IConditionToken localIConditionToken = getFirstConditions().getCondition(localDecisionValue.getX());
      localDecisionValue.setConditions(localList3);
      localDecisionValue.setCondition(localIConditionToken);
      localDecisionValue.setValue(localDecisionValue.getDisplayName());
    }
  }

  public DecisionValue getDecisionValue(List paramList, IConditionToken paramIConditionToken)
  {
    i();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionValue)) && (((DecisionValue)localList.get(i)).checkEqualsElementValue(paramList, paramIConditionToken)))
        return (DecisionValue)localList.get(i);
    if (paramIConditionToken != null)
      for (i = 0; i < localList.size(); i++)
        if (((localList.get(i) instanceof DecisionValue)) && (((DecisionValue)localList.get(i)).checkMatchElementValue(paramList, paramIConditionToken)))
          return (DecisionValue)localList.get(i);
    DecisionValue localDecisionValue = new DecisionValue(paramList, paramIConditionToken);
    super.addChildElement(localDecisionValue);
    return localDecisionValue;
  }

  public DecisionValue getDecisionValue(String paramString, IConditionToken paramIConditionToken)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionValue)) && (((DecisionValue)localList.get(i)).checkEqualsElementValue(paramString, paramIConditionToken)))
        return (DecisionValue)localList.get(i);
    return null;
  }

  public DecisionValue getDecisionValue(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionValue)) && (((DecisionValue)localList.get(i)).getUuid().equals(paramString)))
        return (DecisionValue)localList.get(i);
    return null;
  }

  public boolean addDecisionValue(List paramList, IConditionToken paramIConditionToken, com.flagleader.repository.lang.expression.k paramk)
  {
    DecisionValue localDecisionValue = getDecisionValue(paramList, paramIConditionToken);
    if (localDecisionValue == null)
    {
      localDecisionValue = new DecisionValue(paramList, paramIConditionToken);
      super.addChildElement(localDecisionValue);
    }
    ValueToken localValueToken = (ValueToken)localDecisionValue.getAssignValue();
    localValueToken.clearAllChildren();
    String str = "string";
    if (getMemberElement() != null)
    {
      str = getMemberElement().getValueType();
      localValueToken.changeValueType(getMemberElement().getValueType());
    }
    paramk.a(localValueToken, str);
    return true;
  }

  public int getMaxX()
  {
    return getFirstConditions().getConditionList().size();
  }

  public boolean canPasteValueElement(Object paramObject)
  {
    return paramObject instanceof IVariableObject;
  }

  public boolean pasteValueElement(Object paramObject)
  {
    if ((paramObject instanceof IVariableObject))
      return setMemberElement((IVariableObject)paramObject);
    return false;
  }

  public List getYDecisionValue(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if ((!(localList.get(i) instanceof DecisionValue)) || (((DecisionValue)localList.get(i)).getY() != paramInt))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public List getDecisionValues()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof DecisionValue))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public DecisionValue getDecisionValue(int paramInt1, int paramInt2)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionValue)) && (((DecisionValue)localList.get(i)).getY() == paramInt2) && (((DecisionValue)localList.get(i)).getX() == paramInt1))
        return (DecisionValue)localList.get(i);
    return null;
  }

  public DecisionValue addDecisionValue(int paramInt1, int paramInt2, String paramString)
  {
    DecisionValue localDecisionValue = getDecisionValue(paramInt1, paramInt2);
    if (localDecisionValue != null)
    {
      localDecisionValue.setDisplayName(paramString);
    }
    else
    {
      localDecisionValue = new DecisionValue(paramInt1, paramInt2, paramString);
      addChildElement(localDecisionValue);
    }
    return localDecisionValue;
  }

  public boolean setMemberElement(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject == null)
      return false;
    if (!paramIBusinessObject.equals(getMemberElement()))
    {
      if (!paramIBusinessObject.getUuid().equals(this.elementUuid))
      {
        this.elementUuid = paramIBusinessObject.getUuid();
        setModified(true);
      }
      a(paramIBusinessObject);
      return true;
    }
    return false;
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      localIBusinessObject = h();
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(this.elementUuid))
      {
        setElementUuid(localIBusinessObject.getUuid());
        setNeedSave();
      }
      a(localIBusinessObject);
    }
    return localIBusinessObject;
  }

  protected void a(IBusinessObject paramIBusinessObject)
  {
    if ((paramIBusinessObject instanceof IBusinessObject))
      setUniqueName(paramIBusinessObject.getUniqueName());
  }

  public com.flagleader.repository.lang.g getJavaType()
  {
    if ((h() != null) && ((h() instanceof IBusinessObject)))
      return h().getJavaType();
    return getTypeManager().a("");
  }

  protected IBusinessObject h()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getElementUuid(), getUniqueName());
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public Iterator getAviableMembers()
  {
    if (isSheetWhile())
    {
      List localList = getAllWhileSheets();
      if (localList.size() == 1)
        return ((IWhileObject)localList.get(0)).getFields().iterator();
      if (localList.size() > 1)
      {
        Object localObject = ((IWhileObject)localList.get(0)).getFields().iterator();
        for (int i = 1; i < localList.size(); i++)
          localObject = new com.flagleader.repository.collections.k((Iterator)localObject, ((IWhileObject)localList.get(i)).getFields().iterator());
        return localObject;
      }
      return com.flagleader.repository.collections.g.a();
    }
    return (Iterator)getEnvionment().getDecisionAssgignVariables();
  }

  public boolean isEmpty()
  {
    return (!getFirstConditions().getConditions().hasNext()) || (!getSecondConditions().getConditions().hasNext());
  }

  public String getName()
  {
    return "DecisionRule";
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    return false;
  }

  public boolean clearDebug()
  {
    return false;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDecisionRule(this);
  }

  public IElement deepClone()
  {
    return new DecisionRule(this);
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }

  protected String d()
  {
    return new m().b(this);
  }

  public Map getRelateObjectMap(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IRuleObject))
        continue;
      ((IRuleObject)a().get(i)).findRelateObject(paramMap);
    }
    IBusinessObject localIBusinessObject = h();
    if (localIBusinessObject != null)
      paramMap.put(localIBusinessObject, localIBusinessObject);
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    IBusinessObject localIBusinessObject = h();
    if (localIBusinessObject != null)
      paramMap.put(localIBusinessObject, localIBusinessObject);
    return paramMap;
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

  private Cell a(Row paramRow, int paramInt, CellStyle paramCellStyle)
  {
    Cell localCell = paramRow.createCell(paramInt);
    localCell.setCellStyle(paramCellStyle);
    return localCell;
  }

  public void compareExcelSheet(Sheet paramSheet)
  {
    this.b = 0;
    CellStyle localCellStyle = a(paramSheet.getWorkbook());
    FormulaEvaluator localFormulaEvaluator = paramSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
    Row localRow = paramSheet.getRow(this.b++);
    Cell localCell = localRow.getCell(0);
    if (getMemberElement() != null)
      a(localCell, getMemberElement().getDisplayName(), localCellStyle, localFormulaEvaluator);
    else
      a(localCell, "", localCellStyle, localFormulaEvaluator);
    List localList1 = getFirstConditions().getConditionList();
    for (int i = 0; i < localList1.size(); i++)
      a(localRow.getCell(i + 1), localList1.get(i).toString(), localCellStyle, localFormulaEvaluator);
    List localList2 = getSecondConditions().getConditionList();
    for (int j = 0; j < localList2.size(); j++)
    {
      localRow = paramSheet.getRow(this.b++);
      a(localRow.getCell(0), localList2.get(j).toString(), localCellStyle, localFormulaEvaluator);
      for (int k = 0; k < localList1.size(); k++)
        if (getDecisionValue(k, j) != null)
          a(localRow.getCell(k + 1), getDecisionValue(k, j).getDisplayName(), localCellStyle, localFormulaEvaluator);
        else
          a(localRow.getCell(k + 1), "", localCellStyle, localFormulaEvaluator);
    }
  }

  private void a(Sheet paramSheet, List paramList, CellStyle paramCellStyle)
  {
    if (paramList.size() < getConditionNum())
    {
      List localList = getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
        b(paramSheet, paramList, paramCellStyle);
      else
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          a(paramSheet, localArrayList, paramCellStyle);
        }
    }
    else
    {
      b(paramSheet, paramList, paramCellStyle);
    }
  }

  private void b(Sheet paramSheet, List paramList, CellStyle paramCellStyle)
  {
    Row localRow = paramSheet.createRow(this.b++);
    Cell localCell;
    for (int i = 0; i < getConditionNum(); i++)
    {
      localCell = a(localRow, i, paramCellStyle);
      if (paramList.size() <= i)
        continue;
      localCell.setCellValue(parseShortName(paramList.get(i).toString(), getFirstMember(i + 1)));
    }
    while (i < getConditionNum() + getMaxX())
    {
      localCell = a(localRow, i, paramCellStyle);
      DecisionValue localDecisionValue = getDecisionValue(paramList, getFirstConditions().getCondition(i - getConditionNum()));
      if (localDecisionValue != null)
        localCell.setCellValue(localDecisionValue.getConstantValue().trim());
      else
        localCell.setCellValue("");
      i++;
    }
  }

  public void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle)
  {
    this.b = 0;
    Row localRow = paramSheet.createRow(this.b++);
    Cell localCell = a(localRow, 0, paramCellStyle);
    localCell.setCellValue(getMemberElement().getDisplayName());
    paramSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (short)getConditionNum() - 1));
    localCell = a(localRow, getConditionNum(), paramCellStyle);
    localCell.setCellValue(getSecondMember());
    paramSheet.addMergedRegion(new CellRangeAddress(0, 0, (short)getConditionNum(), (short)getConditionNum() + getMaxX() - 1));
    localRow = paramSheet.createRow(this.b++);
    for (int i = 0; i < getConditionNum(); i++)
    {
      localCell = a(localRow, i, paramCellStyle);
      localCell.setCellValue(getFirstMember(i + 1));
    }
    while (i < getConditionNum() + getMaxX())
    {
      localCell = a(localRow, i, paramCellStyle);
      if (getFirstConditions().getCondition(i - getConditionNum()) != null)
        localCell.setCellValue(parseShortName(getFirstConditions().getCondition(i - getConditionNum()).toString(), getSecondMember()));
      i++;
    }
    List localList1 = getFirstConditions().getConditionList();
    List localList2 = getLineInfos();
    for (int j = 0; j < localList2.size(); j++)
    {
      localRow = paramSheet.createRow(this.b++);
      l locall = (l)localList2.get(j);
      List localList3 = locall.a();
      i = 0;
      Object localObject;
      for (i = 0; i < localList3.size(); i++)
      {
        if (locall.a(i) <= 0)
          continue;
        localObject = parseShortName(localList3.get(i).toString(), getFirstMember(i + 1));
        localCell = a(localRow, i, paramCellStyle);
        localCell.setCellValue((String)localObject);
        if (locall.a(i) <= 1)
          continue;
        paramSheet.addMergedRegion(new CellRangeAddress(this.b - 1, this.b + locall.a(i) - 2, (short)i, (short)i));
      }
      for (i = getConditionNum(); i < getConditionNum() + getMaxX(); i++)
      {
        localObject = getDecisionValue(localList3, getFirstConditions().getCondition(i - getConditionNum()));
        if (localObject == null)
          continue;
        localCell = a(localRow, i, paramCellStyle);
        localCell.setCellValue(((DecisionValue)localObject).getConstantValue().trim());
      }
    }
    for (j = 0; j < getConditionNum() + getMaxX(); j = (short)(j + 1))
      paramSheet.autoSizeColumn(j);
  }

  private Workbook b(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet(getDisplayName());
    Font localFont = paramWorkbook.createFont();
    localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
    localFont.setFontHeightInPoints(12);
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setBorderBottom(1);
    localCellStyle.setBorderLeft(1);
    localCellStyle.setBorderRight(1);
    localCellStyle.setBorderTop(1);
    localCellStyle.setFont(localFont);
    exportExcelSheet(localSheet, localCellStyle);
    return paramWorkbook;
  }

  public void loadFromSheet(Sheet paramSheet)
  {
    this.b = 2;
    StatementSystem localStatementSystem = new StatementSystem(this);
    FormulaEvaluator localFormulaEvaluator = paramSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
    List localList1 = getFirstConditions().getConditionList();
    List localList2 = getLineInfos();
    for (int i = 0; i < localList2.size(); i++)
    {
      Row localRow = paramSheet.getRow(this.b++);
      for (int j = 0; j < localList1.size(); j++)
      {
        Cell localCell = localRow.getCell(j + getConditionNum());
        String str = "";
        if (localCell != null)
          str = a(localCell, localFormulaEvaluator);
        if (str.equals(getLocalString("emptyValue.edit", "")))
          str = "";
        addDecisionValue(((l)localList2.get(i)).a(), (IConditionToken)localList1.get(j), localStatementSystem.h(str));
      }
    }
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

  public int getConditionNum()
  {
    return this.conditionNum;
  }

  public void setConditionNum(int paramInt)
  {
    this.conditionNum = paramInt;
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof DecisionRelateCondition))
    {
      Iterator localIterator1 = ((DecisionRelateCondition)paramIElement).getAcceptElements(new o(this));
      while (localIterator1.hasNext())
      {
        IConditionToken localIConditionToken = (IConditionToken)localIterator1.next();
        String str = localIConditionToken.getUuid();
        Iterator localIterator2 = getAcceptElements(new p(this, str));
        if (!localIterator2.hasNext())
          continue;
        localIConditionToken.setUuid(null);
        setModified(true);
      }
    }
    super.addChildElement(paramIElement, paramInt);
  }

  public int getRuleTableCount()
  {
    return 0;
  }

  public void setModified(boolean paramBoolean)
  {
    if (paramBoolean)
      this.lineinfos = null;
    super.setModified(paramBoolean);
  }

  public boolean replaceVariable(Map paramMap)
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if ((localIBusinessObject != null) && (paramMap.get(localIBusinessObject) != null))
    {
      Object localObject = paramMap.get(localIBusinessObject);
      if ((localObject != null) && ((localObject instanceof IBusinessObject)))
      {
        setMemberElement((IBusinessObject)localObject);
        setModified(true);
      }
    }
    return super.replaceVariable(paramMap);
  }

  public com.flagleader.repository.l[] getLeftPopupMenus()
  {
    List localList = null;
    localList = a(getAviableMembers());
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof ElementList))
      {
        ElementList localElementList = (ElementList)localList.get(i);
        if (localElementList.size() <= 0)
          continue;
        com.flagleader.repository.l locall = new com.flagleader.repository.l(localElementList.getDisplayName(), new q(this, localElementList.getElement()), localElementList.getElement());
        localArrayList.add(locall);
        a(locall, localElementList);
      }
      else
      {
        localArrayList.add(new com.flagleader.repository.l(((IElement)localList.get(i)).getDisplayName(), new q(this, (IElement)localList.get(i)), (IElement)localList.get(i)));
      }
    com.flagleader.repository.l[] arrayOfl = new com.flagleader.repository.l[localArrayList.size()];
    for (i = 0; i < localArrayList.size(); i++)
      arrayOfl[i] = ((com.flagleader.repository.l)localArrayList.get(i));
    return arrayOfl;
  }

  protected List a(Iterator paramIterator)
  {
    if (this.h == null)
      this.h = new ArrayList();
    else
      this.h.clear();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      if (((IBusinessObjectEditen)localObject).getContainer() == null)
      {
        if (!StringUtil.isEmpty(((IBusinessObjectEditen)localObject).getShowGroupName()))
          a(((IBusinessObjectEditen)localObject).getShowGroupName()).add((IBusinessObjectEditen)localObject);
        else
          this.h.add(localObject);
      }
      else
        a((IBusinessObjectEditen)localObject);
    }
    for (int i = 0; i < this.h.size(); i++)
    {
      if ((!(this.h.get(i) instanceof ElementList)) || (((ElementList)this.h.get(i)).getElement() == null))
        continue;
      a((ElementList)this.h.get(i));
    }
    return this.h;
  }

  private void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    a(paramIBusinessObjectEditen.getContainer()).add(paramIBusinessObjectEditen);
  }

  protected ElementList a(String paramString)
  {
    int i = this.h.size();
    for (int j = 0; j < i; j++)
      if (((this.h.get(j) instanceof ElementList)) && (((ElementList)this.h.get(j)).getElement() == null) && (((ElementList)this.h.get(j)).getDisplayName().equals(paramString)))
        return (ElementList)this.h.get(j);
    ElementList localElementList = new ElementList(paramString);
    this.h.add(localElementList);
    return localElementList;
  }

  protected ElementList a(IBusinessObjectContainer paramIBusinessObjectContainer)
  {
    Object localObject1;
    Object localObject2;
    ElementList localElementList2;
    if ((paramIBusinessObjectContainer instanceof TreeValueNode))
    {
      localObject1 = (TreeValueNode)paramIBusinessObjectContainer;
      if (!((TreeValueNode)localObject1).isRootElement())
      {
        localObject2 = ((TreeValueNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int k = 0; k < localElementList2.size(); k++)
          if (((localElementList2.get(k) instanceof ElementList)) && (((ElementList)localElementList2.get(k)).getElement() != null) && (((ElementList)localElementList2.get(k)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(k);
        ElementList localElementList3 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList3);
        return localElementList3;
      }
    }
    else if ((paramIBusinessObjectContainer instanceof XmlNode))
    {
      localObject1 = (XmlNode)paramIBusinessObjectContainer;
      if (!((XmlNode)localObject1).isRootElement())
      {
        localObject2 = ((XmlNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int m = 0; m < localElementList2.size(); m++)
          if (((localElementList2.get(m) instanceof ElementList)) && (((ElementList)localElementList2.get(m)).getElement() != null) && (((ElementList)localElementList2.get(m)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(m);
        ElementList localElementList4 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList4);
        return localElementList4;
      }
    }
    int i = this.h.size();
    for (int j = 0; j < i; j++)
      if (((this.h.get(j) instanceof ElementList)) && (((ElementList)this.h.get(j)).getElement() != null) && (((ElementList)this.h.get(j)).getElement().equals(paramIBusinessObjectContainer)))
        return (ElementList)this.h.get(j);
    ElementList localElementList1 = new ElementList(paramIBusinessObjectContainer);
    this.h.add(localElementList1);
    return (ElementList)(ElementList)localElementList1;
  }

  private int a(ElementList paramElementList, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    int i = 0;
    for (int j = 0; j < paramElementList.size(); j++)
    {
      if ((!(paramElementList.get(j) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(j)).equals(b(paramIBusinessObjectEditen))))
        continue;
      i++;
    }
    return i;
  }

  private IBusinessObjectEditen b(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    for (IBusinessObjectEditen localIBusinessObjectEditen = paramIBusinessObjectEditen; ((localIBusinessObjectEditen.getParent() instanceof IBusinessObjectEditen)) && (!(localIBusinessObjectEditen.getParent() instanceof IBusinessObjectContainer)); localIBusinessObjectEditen = (IBusinessObjectEditen)localIBusinessObjectEditen.getParent());
    return localIBusinessObjectEditen;
  }

  private void a(ElementList paramElementList)
  {
    Object localObject1;
    Object localObject2;
    for (int i = 0; i < paramElementList.size(); i++)
    {
      if ((!(paramElementList.get(i) instanceof IBusinessObjectEditen)) || (a(paramElementList, (IBusinessObjectEditen)paramElementList.get(i)) <= 1))
        continue;
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramElementList.get(i);
      localObject1 = b(localIBusinessObjectEditen);
      localObject2 = new ElementList((IElement)localObject1);
      for (int k = i; k < paramElementList.size(); k++)
      {
        if ((!(paramElementList.get(k) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(k)).equals(localObject1)))
          continue;
        ((ElementList)localObject2).add((IBusinessObjectEditen)paramElementList.get(k));
        paramElementList.remove(k--);
      }
      paramElementList.add(i, (IElement)localObject2);
    }
    HashMap localHashMap = new HashMap();
    for (int j = 0; j < paramElementList.size(); j++)
      if ((paramElementList.get(j) instanceof IBusinessObjectEditen))
      {
        localObject1 = (IBusinessObjectEditen)paramElementList.get(j);
        if (((IBusinessObjectEditen)localObject1).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        localObject2 = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject1).getShowGroupName());
        if (localObject2 == null)
        {
          localObject2 = new ElementList(((IBusinessObjectEditen)localObject1).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject1).getShowGroupName(), localObject2);
          j++;
          paramElementList.add(j, (IElement)localObject2);
        }
        if (localObject2 == null)
          continue;
        ((ElementList)localObject2).add((IElement)localObject1);
      }
      else
      {
        if (!(paramElementList.get(j) instanceof ElementList))
          continue;
        localObject1 = (ElementList)paramElementList.get(j);
        if ((((ElementList)localObject1).getElement() == null) || (!(((ElementList)localObject1).getElement() instanceof IBusinessObjectEditen)))
          continue;
        localObject2 = (IBusinessObjectEditen)((ElementList)localObject1).getElement();
        if (((IBusinessObjectEditen)localObject2).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        ElementList localElementList = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject2).getShowGroupName());
        if (localElementList == null)
        {
          localElementList = new ElementList(((IBusinessObjectEditen)localObject2).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject2).getShowGroupName(), localElementList);
          j++;
          paramElementList.add(j, localElementList);
        }
        if (localElementList == null)
          continue;
        localElementList.add((IElement)localObject1);
      }
  }

  protected void a(com.flagleader.repository.l paraml, ElementList paramElementList)
  {
    IElement[] arrayOfIElement = paramElementList.toArray();
    for (int i = 0; i < arrayOfIElement.length; i++)
      if ((arrayOfIElement[i] instanceof ElementList))
      {
        com.flagleader.repository.l locall = new com.flagleader.repository.l(((ElementList)arrayOfIElement[i]).getDisplayName(), new q(this, ((ElementList)arrayOfIElement[i]).getElement()), ((ElementList)arrayOfIElement[i]).getElement());
        a(locall, (ElementList)arrayOfIElement[i]);
        paraml.a(locall);
      }
      else
      {
        paraml.a(new com.flagleader.repository.l(arrayOfIElement[i].getDisplayName(), new q(this, arrayOfIElement[i]), arrayOfIElement[i]));
      }
  }

  public String getColorType()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if (localIBusinessObject == null)
      return "empty";
    if ((localIBusinessObject instanceof BusinessObjectClass))
      return "class";
    if ((localIBusinessObject instanceof BusinessObjectAttribute))
      return "classAttribute";
    if ((localIBusinessObject instanceof BusinessObjectConstructor))
      return "classConstructor";
    if ((localIBusinessObject instanceof ConstantEnum))
      return "constant";
    if ((localIBusinessObject instanceof MappingVariable))
      return "inoutVariable";
    if ((localIBusinessObject instanceof TempVariable))
      return "tempVariable";
    if ((localIBusinessObject instanceof MappingFunction))
      return "staticFunction";
    if ((localIBusinessObject instanceof GlobalFunction))
      return "staticFunction";
    if ((localIBusinessObject instanceof FunctionMember))
      return "customFunction";
    if ((localIBusinessObject instanceof SheetFieldModel))
      return "sheetField";
    if ((localIBusinessObject instanceof MapValue))
      return "sheetField";
    if ((localIBusinessObject instanceof XmlAttribute))
      return "xmlFunction";
    if ((localIBusinessObject instanceof TreeAttribute))
      return "treeFunction";
    if ((localIBusinessObject instanceof AbstractExcelFieldModel))
      return "excelFunction";
    if ((localIBusinessObject instanceof SoapParameter))
      return "soapFunction";
    return "default";
  }

  public DecisionRule.DecisionElementSelector getContainer()
  {
    return this.g;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
        return true;
      if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
        return false;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionRule
 * JD-Core Version:    0.6.0
 */