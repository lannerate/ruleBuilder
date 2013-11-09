package com.flagleader.repository.tree;

import com.flagleader.engine.MessageUtil;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.e.m;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.sql.DBException;
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

public class DecisionMultiRule extends AbstractRuleTree
  implements IDecision, IRuleContainer, IRuleTree, am
{
  public static final String NAME = "DecisionMultiRule";
  public static final String DISPLAYNAME = getLocalString("DecisionMultiRule.text");
  public static final String COMMNAME = getLocalString("DecisionMultiRule.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("DecisionMultiRule", DISPLAYNAME, DISPLAYNAME);
  private int conditionNum = 1;
  private int valueNum = 1;
  private List lineinfos = null;
  int b = 0;

  public DecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    super(paramDecisionMultiRule);
    this.conditionNum = paramDecisionMultiRule.conditionNum;
    this.valueNum = paramDecisionMultiRule.valueNum;
  }

  public DecisionMultiRule()
  {
  }

  public DecisionMultiRule(String paramString)
  {
    super(paramString);
  }

  public IMultiConditionToken getConditions(int paramInt)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof IMultiConditionToken)) && (((IMultiConditionToken)localList.get(i)).getType() == paramInt))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken(paramInt);
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public boolean isValidConditoin(String paramString)
  {
    List localList1 = a();
    for (int i = 0; i < localList1.size(); i++)
    {
      if (!(localList1.get(i) instanceof IMultiConditionToken))
        continue;
      List localList2 = ((IMultiConditionToken)localList1.get(i)).getConditionList();
      for (int j = 0; j < localList2.size(); j++)
        if (((IConditionToken)localList2.get(j)).getUuid().equals(paramString))
          return true;
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
        return false;
      if (!isValidConditoin(paramString.substring(j * i, (j + 1) * i)))
        return false;
    }
    return true;
  }

  public DecisionElementValue getDecisionValue(List paramList, IBusinessObject paramIBusinessObject)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionElementValue)) && (((DecisionElementValue)localList.get(i)).checkEqualsElementValue(paramList, paramIBusinessObject)))
        return (DecisionElementValue)localList.get(i);
    if (paramIBusinessObject != null)
      for (i = 0; i < localList.size(); i++)
        if (((localList.get(i) instanceof DecisionElementValue)) && (((DecisionElementValue)localList.get(i)).checkMatchElementValue(paramList, paramIBusinessObject)))
          return (DecisionElementValue)localList.get(i);
    if (paramIBusinessObject != null)
    {
      DecisionElementValue localDecisionElementValue = new DecisionElementValue(paramList, paramIBusinessObject);
      super.addChildElement(localDecisionElementValue);
      return localDecisionElementValue;
    }
    return null;
  }

  public DecisionElementValue getDecisionValue(String paramString, IBusinessObject paramIBusinessObject)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionElementValue)) && (((DecisionElementValue)localList.get(i)).checkEqualsElementValue(paramString, paramIBusinessObject)))
        return (DecisionElementValue)localList.get(i);
    return null;
  }

  public DecisionElementValue getDecisionValue(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionElementValue)) && (((DecisionElementValue)localList.get(i)).getUuid().equals(paramString)))
        return (DecisionElementValue)localList.get(i);
    return null;
  }

  public boolean addDecisionValue(List paramList, IBusinessObject paramIBusinessObject, com.flagleader.repository.lang.expression.k paramk)
  {
    DecisionElementValue localDecisionElementValue = getDecisionValue(paramList, paramIBusinessObject);
    if (localDecisionElementValue == null)
    {
      localDecisionElementValue = new DecisionElementValue(paramList, paramIBusinessObject);
      super.addChildElement(localDecisionElementValue);
    }
    ValueToken localValueToken = (ValueToken)localDecisionElementValue.getAssignValue();
    localValueToken.clearAllChildren();
    paramk.a(localValueToken, paramIBusinessObject.getValueType());
    return true;
  }

  public boolean addDecisionValue(List paramList, IBusinessObject paramIBusinessObject, String paramString)
  {
    DecisionElementValue localDecisionElementValue = getDecisionValue(paramList, paramIBusinessObject);
    if (localDecisionElementValue == null)
    {
      localDecisionElementValue = new DecisionElementValue(paramList, paramIBusinessObject);
      super.addChildElement(localDecisionElementValue);
    }
    localDecisionElementValue.setValue(paramString);
    return true;
  }

  public boolean addDecisionValue(List paramList, int paramInt, String paramString)
  {
    if ((getDecisionElement(paramInt) != null) && (getDecisionElement(paramInt).getMemberElement() != null))
      return addDecisionValue(paramList, getDecisionElement(paramInt).getMemberElement(), paramString);
    return false;
  }

  public boolean addDecisionValue(String paramString1, int paramInt, String paramString2)
  {
    if ((getDecisionElement(paramInt) != null) && (getDecisionElement(paramInt).getMemberElement() != null))
    {
      DecisionElementValue localDecisionElementValue = getDecisionValue(paramString1, getDecisionElement(paramInt).getMemberElement());
      if (localDecisionElementValue == null)
      {
        localDecisionElementValue = new DecisionElementValue(paramString1, getDecisionElement(paramInt).getMemberElement());
        super.addChildElement(localDecisionElementValue);
      }
      try
      {
        ValueToken localValueToken = (ValueToken)localDecisionElementValue.getAssignValue();
        localValueToken.clearAllChildren();
        new StatementSystem(this).h(paramString2).a(localValueToken, localValueToken.getValueType());
      }
      catch (Exception localException)
      {
        localDecisionElementValue.setValue(paramString2);
      }
      return true;
    }
    return false;
  }

  public List getDecisionValues(IBusinessObject paramIBusinessObject)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if ((!(localList.get(i) instanceof DecisionElementValue)) || (!((DecisionElementValue)localList.get(i)).checkElementValue(paramIBusinessObject)))
        continue;
      localArrayList.add((DecisionElementValue)localList.get(i));
    }
    return localArrayList;
  }

  public DecisionElement getDecisionElement(int paramInt)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionElement)) && (((DecisionElement)localList.get(i)).getPos() == paramInt))
        return (DecisionElement)localList.get(i);
    DecisionElement localDecisionElement = new DecisionElement();
    localDecisionElement.setPos(paramInt);
    super.addChildElement(localDecisionElement);
    return localDecisionElement;
  }

  public void removeDecisionElement(int paramInt)
  {
    DecisionElement localDecisionElement = getDecisionElement(paramInt);
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if ((!(localList.get(i) instanceof DecisionElementValue)) || (!((DecisionElementValue)localList.get(i)).checkElementValue(localDecisionElement.getMemberElement())))
        continue;
      localList.remove(i);
    }
    localDecisionElement.dispose();
  }

  public boolean canPasteValueElement(int paramInt, Object paramObject)
  {
    return paramObject instanceof IVariableObject;
  }

  public boolean pasteValueElement(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof IVariableObject))
      return setDecisionElement(paramInt, (IVariableObject)paramObject);
    return false;
  }

  public int[] getNextDecision(int[] paramArrayOfInt)
  {
    for (int i = paramArrayOfInt.length - 1; i >= 0; i--)
    {
      if (paramArrayOfInt[i] < getConditions(i + 1).getConditionList().size() - 1)
      {
        paramArrayOfInt[i] += 1;
        return paramArrayOfInt;
      }
      paramArrayOfInt[i] = 0;
    }
    return null;
  }

  public boolean setDecisionElement(int paramInt, IBusinessObject paramIBusinessObject)
  {
    DecisionElement localDecisionElement = getDecisionElement(paramInt);
    if (localDecisionElement == null)
    {
      localDecisionElement = new DecisionElement();
      localDecisionElement.setPos(paramInt);
      super.addChildElement(localDecisionElement);
    }
    localDecisionElement.setElementUuid(paramIBusinessObject.getUuid());
    localDecisionElement.setUniqueName(paramIBusinessObject.getUniqueName());
    return true;
  }

  public List getDecisionElements()
  {
    ArrayList localArrayList = new ArrayList(this.valueNum);
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof DecisionElement))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public boolean isEmpty()
  {
    for (int i = 0; i < this.conditionNum; i++)
      if (getConditions(i + 1).getConditions().hasNext())
        return false;
    return true;
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
      return ((IRuleSet)getParent()).getRuleAndSetCount();
    return 0;
  }

  public int getMinPos()
  {
    return 0;
  }

  public int getPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)) && (getParent().getElementPos(this) >= 0))
      return getParent().getElementPos(this);
    return 0;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
    {
      if (paramInt < 0)
        return;
      int i = getParent().getElementPos(this);
      if (i == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, paramInt);
    }
  }

  public String getName()
  {
    return "DecisionMultiRule";
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
    return paramRepositoryVisitor.visitDecisionMultiRule(this);
  }

  public IElement deepClone()
  {
    return new DecisionMultiRule(this);
  }

  public Iterator getAviableMembers()
  {
    if (hasSheetWhile())
    {
      Object localObject = getEnvionment().getDecisionAssgignVariables();
      List localList = getAllWhileSheets();
      for (int i = 0; i < localList.size(); i++)
        localObject = new com.flagleader.repository.collections.k((Iterator)localObject, ((IWhileObject)localList.get(i)).getFields().iterator());
      return localObject;
    }
    return (Iterator)getEnvionment().getDecisionAssgignVariables();
  }

  public int getConditionNum()
  {
    return this.conditionNum;
  }

  public void setConditionNum(int paramInt)
  {
    this.conditionNum = paramInt;
  }

  public int getValueNum()
  {
    return this.valueNum;
  }

  public void setValueNum(int paramInt)
  {
    this.valueNum = paramInt;
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
      if ((a().get(i) instanceof IRuleObject))
      {
        ((IRuleObject)a().get(i)).findRelateObject(paramMap);
      }
      else if ((a().get(i) instanceof DecisionRelateCondition))
      {
        ((DecisionRelateCondition)a().get(i)).getConditions().findRelateObject(paramMap);
      }
      else
      {
        if (!(a().get(i) instanceof DecisionElement))
          continue;
        IBusinessObject localIBusinessObject = ((DecisionElement)a().get(i)).getMemberElement();
        if (localIBusinessObject == null)
          continue;
        paramMap.put(localIBusinessObject, localIBusinessObject);
      }
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    for (int i = 0; i < a().size(); i++)
      if ((a().get(i) instanceof IRuleObject))
      {
        ((IRuleObject)a().get(i)).findAssignObject(paramMap, paramBoolean);
      }
      else
      {
        if (!(a().get(i) instanceof DecisionElement))
          continue;
        IBusinessObject localIBusinessObject = ((DecisionElement)a().get(i)).getMemberElement();
        if (localIBusinessObject == null)
          continue;
        paramMap.put(localIBusinessObject, localIBusinessObject);
      }
    return paramMap;
  }

  public void loadFromSheet(Sheet paramSheet)
  {
    StatementSystem localStatementSystem = new StatementSystem(this);
    IWhileObject localIWhileObject1 = 0;
    for (Row localRow = paramSheet.getRow(localIWhileObject1++); (localRow.getCell(0) != null) && (StringUtil.isEmpty(localRow.getCell(0).getStringCellValue())); localRow = paramSheet.getRow(localIWhileObject1++));
    if ((localRow.getCell(0) != null) && (localRow.getCell(0).getStringCellValue().startsWith(u.a("decitioncondition.text", "condition"))))
    {
      for (int i = 0; i < 100; i++)
        if ((localRow.getCell(i) != null) && (localRow.getCell(i).getStringCellValue().startsWith(u.a("decitioncondition.text", "condition"))))
          this.conditionNum = (i + 1);
        else if ((localRow.getCell(i) != null) && (localRow.getCell(i).getStringCellValue().startsWith(u.a("decisionassign.text", "assign"))))
          this.valueNum = (i - this.conditionNum + 1);
        else
          if ((localRow.getCell(i) == null) || (StringUtil.isEmpty(localRow.getCell(i).getStringCellValue())))
            break;
      localRow = paramSheet.getRow(localIWhileObject1++);
    }
    String[] arrayOfString1 = new String[getConditionNum()];
    String[] arrayOfString2 = new String[getValueNum()];
    int j = 0;
    for (j = 0; j < arrayOfString1.length; j++)
    {
      localObject1 = localRow.getCell((short)j);
      if (localObject1 == null)
        continue;
      arrayOfString1[j] = ((Cell)localObject1).getStringCellValue();
    }
    while (j < arrayOfString1.length + arrayOfString2.length)
    {
      localObject1 = localRow.getCell((short)j);
      if (localObject1 != null)
        arrayOfString2[(j - arrayOfString1.length)] = ((Cell)localObject1).getStringCellValue();
      j++;
    }
    Object localObject1 = new IBusinessObject[getConditionNum()];
    IBusinessObject[] arrayOfIBusinessObject = new IBusinessObject[getValueNum()];
    int k;
    Object localObject3;
    int n;
    for (j = 0; j < arrayOfString1.length; j++)
    {
      if (hasSheetWhile())
      {
        localObject2 = getAllWhileSheets();
        for (k = 0; k < ((List)localObject2).size(); k++)
        {
          localIWhileObject2 = (IWhileObject)((List)localObject2).get(k);
          localObject3 = localIWhileObject2.getFields();
          for (n = 0; n < ((List)localObject3).size(); n++)
          {
            if (!((IVariableObject)((List)localObject3).get(n)).getDisplayName().equals(arrayOfString1[j]))
              continue;
            localObject1[j] = ((IVariableObject)((List)localObject3).get(n));
            break;
          }
        }
      }
      else
      {
        localObject1[j] = getEnvionment().getBusinessObject(arrayOfString1[j], canIncludeSheet(), getAllWhileSheets());
      }
      if (localObject1[j] != null)
        continue;
      throw new DBException(arrayOfString1[j] + " is not exits!");
    }
    for (j = 0; j < arrayOfString2.length; j++)
    {
      if (isActiveSheetWhile())
      {
        localObject2 = getAllWhileSheets();
        for (k = 0; k < ((List)localObject2).size(); k++)
        {
          localIWhileObject2 = (IWhileObject)((List)localObject2).get(k);
          localObject3 = localIWhileObject2.getFields();
          for (n = 0; n < ((List)localObject3).size(); n++)
          {
            if (!((IVariableObject)((List)localObject3).get(n)).getDisplayName().equals(arrayOfString2[j]))
              continue;
            arrayOfIBusinessObject[j] = ((IVariableObject)((List)localObject3).get(n));
            break;
          }
        }
      }
      else
      {
        arrayOfIBusinessObject[j] = getEnvionment().getBusinessObject(arrayOfString2[j], canIncludeSheet(), getAllWhileSheets());
      }
      if (arrayOfIBusinessObject[j] == null)
        throw new DBException(arrayOfString2[j] + " is not exits!");
      setDecisionElement(j + 1, arrayOfIBusinessObject[j]);
    }
    Object localObject2 = new IConditionToken[getConditionNum()];
    FormulaEvaluator localFormulaEvaluator = paramSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
    for (IWhileObject localIWhileObject2 = localIWhileObject1; localIWhileObject2 < 65534; localIWhileObject2++)
    {
      localRow = paramSheet.getRow(localIWhileObject2);
      if ((localRow == null) || (localRow.getCell(0) == null))
        break;
      Object localObject4;
      for (j = 0; j < arrayOfString1.length; j++)
      {
        localObject3 = localRow.getCell(j);
        String str = "";
        if (localObject3 == null)
          continue;
        str = a((Cell)localObject3, localFormulaEvaluator);
        if ((str != null) && (str.length() > 0))
        {
          localObject4 = getConditions(j + 1);
          localObject2[j] = ((IMultiConditionToken)localObject4).findCondition(localObject1[j], str.trim(), localStatementSystem);
        }
        else
        {
          localObject2[j] = null;
        }
      }
      int m = 1;
      for (int i1 = 0; i1 < localObject2.length; i1++)
      {
        if (localObject2[i1] == null)
          continue;
        m = 0;
        break;
      }
      if (m != 0)
        break;
      do
      {
        Cell localCell = localRow.getCell((short)j);
        localObject4 = "";
        if (localCell != null)
          localObject4 = a(localCell, localFormulaEvaluator);
        ArrayList localArrayList = new ArrayList(localObject2.length);
        for (int i2 = 0; i2 < localObject2.length; i2++)
        {
          if (localObject2[i2] == null)
            continue;
          localArrayList.add(localObject2[i2]);
        }
        if (((String)localObject4).equals(getLocalString("emptyValue.edit", "")))
          localObject4 = "";
        addDecisionValue(localArrayList, arrayOfIBusinessObject[(j - arrayOfString1.length)], localStatementSystem.h((String)localObject4));
        j++;
      }
      while (j < arrayOfString1.length + arrayOfString2.length);
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
    for (Row localRow = paramSheet.getRow(this.b++); (localRow.getCell(0) != null) && ((StringUtil.isEmpty(localRow.getCell(0).getStringCellValue())) || (localRow.getCell(0).getStringCellValue().startsWith(u.a("decitioncondition.text", "condition")))); localRow = paramSheet.getRow(this.b++));
    localRow = paramSheet.getRow(this.b++);
    for (int i = 0; i < getConditionNum(); i++)
    {
      IMultiConditionToken localIMultiConditionToken = getConditions(i + 1);
      if (localIMultiConditionToken.getSameFirstValue() != null)
        a(localRow.getCell(i), localIMultiConditionToken.getSameFirstValue().getDisplayName(), localCellStyle, localFormulaEvaluator);
      else
        a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
    }
    while (i < getConditionNum() + getValueNum())
    {
      if ((getDecisionElement(i - getConditionNum() + 1) != null) && (getDecisionElement(i - getConditionNum() + 1).getMemberElement() != null))
        a(localRow.getCell(i), getDecisionElement(i - getConditionNum() + 1).getMemberElement().getDisplayName(), localCellStyle, localFormulaEvaluator);
      else
        a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
      i++;
    }
    int j = 1;
    int[] arrayOfInt = new int[getConditionNum()];
    for (int k = 0; k < getConditionNum(); k++)
      arrayOfInt[k] = 0;
    do
    {
      localRow = paramSheet.getRow((short)(this.b++));
      i = 0;
      ArrayList localArrayList = new ArrayList(getConditionNum());
      Object localObject;
      while (i < getConditionNum())
      {
        localObject = getConditions(i + 1);
        IConditionToken localIConditionToken = ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i]);
        if (localIConditionToken != null)
          localArrayList.add(localIConditionToken);
        if (localIConditionToken != null)
        {
          if (((IMultiConditionToken)localObject).getSameFirstValue() == null)
            a(localRow.getCell(i), localIConditionToken.toString(), localCellStyle, localFormulaEvaluator);
          else if ((localIConditionToken.getCompareOperator().getType() == 0) && (!localIConditionToken.getNextTests().hasNext()))
          {
            if (localIConditionToken.getComparedValue() != null)
              a(localRow.getCell(i), localIConditionToken.getComparedValue().toString(), localCellStyle, localFormulaEvaluator);
            else
              a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
          }
          else
            a(localRow.getCell(i), parseShortName(localIConditionToken.toString(), ((IMultiConditionToken)localObject).getSameFirstValue().toString()), localCellStyle, localFormulaEvaluator);
        }
        else
          a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
        i++;
      }
      while (i < getConditionNum() + getValueNum())
      {
        if (getDecisionElement(i - getConditionNum() + 1) == null)
        {
          a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
        }
        else
        {
          localObject = getDecisionValue(localArrayList, getDecisionElement(i - getConditionNum() + 1).getMemberElement());
          if ((getDecisionElement(i - getConditionNum() + 1) != null) && (localObject != null))
            a(localRow.getCell(i), ((DecisionElementValue)localObject).getConstantValue(), localCellStyle, localFormulaEvaluator);
          else
            a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
        }
        i++;
      }
      arrayOfInt = getNextDecision(arrayOfInt);
    }
    while (arrayOfInt != null);
  }

  public void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle)
  {
    this.b = 0;
    Row localRow = paramSheet.createRow(this.b++);
    int i = 0;
    int j;
    if (getConditionNum() > 0)
      for (j = 0; j < getConditionNum(); j++)
      {
        localObject2 = localRow.createCell(i++);
        ((Cell)localObject2).setCellValue(u.a("decitioncondition.text", "condition") + (j + 1));
      }
    if (getValueNum() > 0)
      for (j = 0; j < getValueNum(); j++)
      {
        localObject2 = localRow.createCell(i++);
        ((Cell)localObject2).setCellValue(u.a("decisionassign.text", "assign") + (j + 1));
      }
    localRow = paramSheet.createRow(this.b++);
    Object localObject1;
    for (i = 0; i < getConditionNum(); i++)
    {
      localObject1 = getConditions(i + 1);
      localObject2 = a(localRow, i, paramCellStyle);
      if (((IMultiConditionToken)localObject1).getSameFirstValue() != null)
        ((Cell)localObject2).setCellValue(((IMultiConditionToken)localObject1).getSameFirstValue().getDisplayName());
      else
        ((Cell)localObject2).setCellValue("");
    }
    while (i < getConditionNum() + getValueNum())
    {
      localObject1 = a(localRow, i, paramCellStyle);
      if ((getDecisionElement(i - getConditionNum() + 1) != null) && (getDecisionElement(i - getConditionNum() + 1).getMemberElement() != null))
        ((Cell)localObject1).setCellValue(getDecisionElement(i - getConditionNum() + 1).getMemberElement().getDisplayName());
      else
        ((Cell)localObject1).setCellValue("");
      i++;
    }
    int k = 1;
    Object localObject2 = new int[getConditionNum()];
    for (int m = 0; m < getConditionNum(); m++)
      localObject2[m] = 0;
    do
    {
      localRow = paramSheet.createRow((short)(this.b++));
      i = 0;
      ArrayList localArrayList = new ArrayList(getConditionNum());
      Cell localCell;
      Object localObject3;
      while (i < getConditionNum())
      {
        localCell = a(localRow, i, paramCellStyle);
        localObject3 = getConditions(i + 1);
        IConditionToken localIConditionToken = ((IMultiConditionToken)localObject3).getCondition(localObject2[i]);
        if (localIConditionToken != null)
          localArrayList.add(localIConditionToken);
        if (localIConditionToken != null)
        {
          if (((IMultiConditionToken)localObject3).getSameFirstValue() == null)
            localCell.setCellValue(localIConditionToken.toString());
          else if ((localIConditionToken.getCompareOperator().getType() == 0) && (!localIConditionToken.getNextTests().hasNext()))
          {
            if (localIConditionToken.getComparedValue() != null)
              localCell.setCellValue(localIConditionToken.getComparedValue().toString());
            else
              localCell.setCellValue("");
          }
          else
            localCell.setCellValue(parseShortName(localIConditionToken.toString(), ((IMultiConditionToken)localObject3).getSameFirstValue().toString()));
        }
        else
          localCell.setCellValue("");
        i++;
      }
      while (i < getConditionNum() + getValueNum())
      {
        localCell = a(localRow, i, paramCellStyle);
        if (getDecisionElement(i - getConditionNum() + 1) == null)
        {
          localCell.setCellValue("");
        }
        else
        {
          localObject3 = getDecisionValue(localArrayList, getDecisionElement(i - getConditionNum() + 1).getMemberElement());
          if ((getDecisionElement(i - getConditionNum() + 1) != null) && (localObject3 != null))
            localCell.setCellValue(((DecisionElementValue)localObject3).getConstantValue());
          else
            localCell.setCellValue("");
        }
        i++;
      }
      localObject2 = getNextDecision(localObject2);
    }
    while (localObject2 != null);
    for (int n = 0; n < getConditionNum() + getValueNum(); n = (short)(n + 1))
      paramSheet.autoSizeColumn(n);
    paramSheet.createFreezePane(0, 2, 0, 2);
  }

  public List getLineInfos()
  {
    if (this.lineinfos == null)
    {
      this.lineinfos = new ArrayList();
      int i = 1;
      int[] arrayOfInt = new int[getConditionNum()];
      for (int j = 0; j < getConditionNum(); j++)
        arrayOfInt[j] = 0;
      do
      {
        j = 0;
        ArrayList localArrayList = new ArrayList(getConditionNum());
        while (j < getConditionNum())
        {
          IMultiConditionToken localIMultiConditionToken = getConditions(j + 1);
          IConditionToken localIConditionToken = localIMultiConditionToken.getCondition(arrayOfInt[j]);
          if (localIConditionToken != null)
            localArrayList.add(localIConditionToken);
          j++;
        }
        this.lineinfos.add(new l(localArrayList));
        arrayOfInt = getNextDecision(arrayOfInt);
      }
      while (arrayOfInt != null);
    }
    return this.lineinfos;
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

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof DecisionMultiConditionToken))
    {
      Iterator localIterator1 = ((DecisionMultiConditionToken)paramIElement).getAcceptChildren(new j(this));
      while (localIterator1.hasNext())
      {
        IConditionToken localIConditionToken = (IConditionToken)localIterator1.next();
        String str = localIConditionToken.getUuid();
        Iterator localIterator2 = getAcceptElements(new k(this, str));
        if (!localIterator2.hasNext())
          continue;
        localIConditionToken.setUuid(null);
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionMultiRule
 * JD-Core Version:    0.6.0
 */