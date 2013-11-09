package com.flagleader.repository.tree;

import com.flagleader.engine.MessageUtil;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.collections.g;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.lang.expression.i;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
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

public class DecisionRelateRule extends AbstractRuleTree
  implements IDecision, IRuleContainer, IRuleTree, am
{
  public static final String NAME = "DecisionRelateRule";
  public static final String DISPLAYNAME = getLocalString("DecisionRelateRule.text");
  public static final String COMMNAME = getLocalString("DecisionRelateRule.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("DecisionRelateRule", DISPLAYNAME, DISPLAYNAME);
  private int conditionNum = 1;
  private int valueNum = 1;
  private List lineinfos = null;
  int b = 0;

  public DecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    super(paramDecisionRelateRule);
    this.valueNum = paramDecisionRelateRule.valueNum;
    this.conditionNum = paramDecisionRelateRule.conditionNum;
  }

  public DecisionRelateRule()
  {
  }

  public DecisionRelateRule(String paramString)
  {
    super(paramString);
  }

  public IMultiConditionToken getConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof IMultiConditionToken))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken(1);
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public String getFirstMember(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt <= 1)
    {
      localObject1 = getConditions();
      List localList1 = ((IMultiConditionToken)localObject1).getConditionList();
      if ((localList1.size() > 0) && (((IConditionToken)localList1.get(0)).getFirstValue() != null))
      {
        localObject2 = ((IConditionToken)localList1.get(0)).getFirstValue().toString();
        if ((((String)localObject2).indexOf("{") > 0) && (((String)localObject2).indexOf("}") > ((String)localObject2).indexOf("{")))
          return ((String)localObject2).substring(((String)localObject2).indexOf("{") + 1, ((String)localObject2).indexOf("}"));
        return localObject2;
      }
    }
    else
    {
      localObject1 = a();
      for (int i = 0; i < ((List)localObject1).size(); i++)
      {
        if ((!(((List)localObject1).get(i) instanceof DecisionRelateCondition)) || (((DecisionRelateCondition)((List)localObject1).get(i)).getConditionPos() != paramInt))
          continue;
        localObject2 = ((DecisionRelateCondition)((List)localObject1).get(i)).getConditions();
        List localList2 = ((IMultiConditionToken)localObject2).getConditionList();
        if ((localList2.size() <= 0) || (((IConditionToken)localList2.get(0)).getFirstValue() == null))
          continue;
        String str = ((IConditionToken)localList2.get(0)).getFirstValue().toString();
        if ((str.indexOf("{") > 0) && (str.indexOf("}") > str.indexOf("{")))
          return str.substring(str.indexOf("{") + 1, str.indexOf("}"));
        return str;
      }
    }
    return (String)(String)"";
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
      List localList1 = getConditions().getConditionList();
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
      {
        b(paramList1, paramList2);
      }
      else
      {
        if (getValueNum() == 0)
          b(paramList1, paramList2);
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList2.size() + 1);
          localArrayList.addAll(paramList2);
          localArrayList.add(localList.get(i));
          a(paramList1, localArrayList);
        }
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
    DecisionElementValue localDecisionElementValue = new DecisionElementValue(paramList, paramIBusinessObject);
    super.addChildElement(localDecisionElementValue);
    return localDecisionElementValue;
  }

  public DecisionRelateAction getDecisionAction(List paramList)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof DecisionRelateAction)) && (((DecisionRelateAction)localList.get(i)).checkEqualsElementValue(paramList)))
        return (DecisionRelateAction)localList.get(i);
    DecisionRelateAction localDecisionRelateAction = new DecisionRelateAction(paramList);
    super.addChildElement(localDecisionRelateAction);
    return localDecisionRelateAction;
  }

  public boolean isEmptyAction()
  {
    int i = 1;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if ((!(localList.get(j) instanceof DecisionRelateAction)) || (((DecisionRelateAction)localList.get(j)).isEmpty()))
        continue;
      i = 0;
    }
    return i;
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
    return !getConditions().getConditions().hasNext();
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
    return "DecisionRelateRule";
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
    return paramRepositoryVisitor.visitDecisionRelateRule(this);
  }

  public IElement deepClone()
  {
    return new DecisionRelateRule(this);
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
      return g.a();
    }
    return (Iterator)getEnvionment().getDecisionAssgignVariables();
  }

  public int getValueNum()
  {
    return this.valueNum;
  }

  public void setValueNum(int paramInt)
  {
    this.valueNum = paramInt;
  }

  public int getConditionNum()
  {
    return this.conditionNum;
  }

  public void setConditionNum(int paramInt)
  {
    this.conditionNum = paramInt;
  }

  protected String d()
  {
    return new com.flagleader.repository.e.m().b(this);
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
      else if ((a().get(i) instanceof DecisionRelateAction))
      {
        ((DecisionRelateAction)a().get(i)).getThenActions().findRelateObject(paramMap);
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

  public void initByList(String paramString1, String paramString2, List paramList)
  {
    StatementSystem localStatementSystem = new StatementSystem(this);
    String[] arrayOfString1 = paramString1.split(",");
    String[] arrayOfString2 = paramString2.split(",");
    this.conditionNum = arrayOfString1.length;
    this.valueNum = arrayOfString2.length;
    int i = 0;
    IBusinessObject[] arrayOfIBusinessObject1 = new IBusinessObject[arrayOfString1.length];
    IBusinessObject[] arrayOfIBusinessObject2 = new IBusinessObject[arrayOfString2.length];
    Object localObject2;
    Object localObject3;
    int k;
    for (i = 0; i < arrayOfString1.length; i++)
    {
      if (hasSheetWhile())
      {
        localObject1 = getAllWhileSheets();
        for (j = 0; j < ((List)localObject1).size(); j++)
        {
          localObject2 = (IWhileObject)((List)localObject1).get(j);
          localObject3 = ((IWhileObject)localObject2).getFields();
          for (k = 0; k < ((List)localObject3).size(); k++)
          {
            if (!((IVariableObject)((List)localObject3).get(k)).getDisplayName().equals(arrayOfString1[i]))
              continue;
            arrayOfIBusinessObject1[i] = ((IVariableObject)((List)localObject3).get(k));
            break;
          }
        }
      }
      else
      {
        arrayOfIBusinessObject1[i] = getEnvionment().getBusinessObject(arrayOfString1[i], canIncludeSheet(), getAllWhileSheets());
      }
      if (arrayOfIBusinessObject1[i] != null)
        continue;
      throw new DBException(arrayOfString1[i] + " is not exits!");
    }
    for (i = 0; i < arrayOfString2.length; i++)
    {
      if (isActiveSheetWhile())
      {
        localObject1 = getAllWhileSheets();
        for (j = 0; j < ((List)localObject1).size(); j++)
        {
          localObject2 = (IWhileObject)((List)localObject1).get(j);
          localObject3 = ((IWhileObject)localObject2).getFields();
          for (k = 0; k < ((List)localObject3).size(); k++)
          {
            if (!((IVariableObject)((List)localObject3).get(k)).getDisplayName().equals(arrayOfString2[i]))
              continue;
            arrayOfIBusinessObject2[i] = ((IVariableObject)((List)localObject3).get(k));
            break;
          }
        }
      }
      else
      {
        arrayOfIBusinessObject2[i] = getEnvionment().getBusinessObject(arrayOfString2[i], canIncludeSheet(), getAllWhileSheets());
      }
      if (arrayOfIBusinessObject2[i] == null)
        throw new DBException(arrayOfString2[i] + " is not exits!");
      setDecisionElement(i + 1, arrayOfIBusinessObject2[i]);
    }
    Object localObject1 = new IConditionToken[arrayOfString1.length];
    for (int j = 0; j < paramList.size(); j++)
    {
      localObject2 = (List)paramList.get(j);
      for (i = 0; i < arrayOfString1.length; i++)
      {
        localObject3 = ((List)localObject2).get(i);
        str = "";
        if (localObject3 == null)
          continue;
        str = StringUtil.stringValue(localObject3);
        if (str.length() <= 0)
          continue;
        localObject4 = null;
        if (i == 0)
          localObject4 = getConditions();
        else
          localObject4 = getRelateCondition(localObject1[(i - 1)], i).getConditions();
        localObject1[i] = ((IMultiConditionToken)localObject4).findCondition(arrayOfIBusinessObject1[i], str.trim(), localStatementSystem);
      }
      while (i < arrayOfString1.length + arrayOfString2.length)
      {
        localObject3 = ((List)localObject2).get(i);
        str = "";
        if (localObject3 != null)
          str = StringUtil.stringValue(localObject3);
        localObject4 = new ArrayList(localObject1.length);
        for (m = 0; m < localObject1.length; m++)
          ((List)localObject4).add(localObject1[m]);
        if (str.equals(getLocalString("emptyValue.edit", "")))
          str = "";
        addDecisionValue((List)localObject4, arrayOfIBusinessObject2[(i - arrayOfString1.length)], localStatementSystem.h(str));
        i++;
      }
      if (((List)localObject2).size() <= i)
        continue;
      localObject3 = ((List)localObject2).get(i);
      String str = "";
      if (localObject3 != null)
        str = StringUtil.stringValue(localObject3);
      Object localObject4 = new ArrayList(localObject1.length);
      for (int m = 0; m < localObject1.length; m++)
        ((List)localObject4).add(localObject1[m]);
      if (str.equals(getLocalString("emptyValue.edit", "")))
        str = "";
      getDecisionAction((List)localObject4).getThenActions().dispose();
      if (str.length() <= 0)
        continue;
      i[] arrayOfi = localStatementSystem.f(str);
      for (int n = 0; n < arrayOfi.length; n++)
      {
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        getDecisionAction((List)localObject4).getThenActions().addChildElement(localStatementContainerToken);
        arrayOfi[n].a(localStatementContainerToken);
      }
    }
  }

  private void a(Sheet paramSheet)
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
      for (j = 0; j < arrayOfString1.length; j++)
      {
        localObject3 = localRow.getCell(j);
        String str = "";
        if (localObject3 == null)
          continue;
        str = a((Cell)localObject3, localFormulaEvaluator);
        if ((str != null) && (str.length() > 0))
        {
          localObject4 = null;
          if (j == 0)
            localObject4 = getConditions();
          else
            localObject4 = getRelateCondition(localObject2[(j - 1)], j).getConditions();
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
        localCell = localRow.getCell((short)j);
        localObject4 = "";
        if (localCell != null)
          localObject4 = a(localCell, localFormulaEvaluator);
        localArrayList = new ArrayList(localObject2.length);
        for (i2 = 0; i2 < localObject2.length; i2++)
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
      Cell localCell = localRow.getCell((short)j);
      Object localObject4 = "";
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
      getDecisionAction(localArrayList).getThenActions().dispose();
      if (((String)localObject4).length() <= 0)
        continue;
      i[] arrayOfi = localStatementSystem.f((String)localObject4);
      for (int i3 = 0; i3 < arrayOfi.length; i3++)
      {
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        getDecisionAction(localArrayList).getThenActions().addChildElement(localStatementContainerToken);
        arrayOfi[i3].a(localStatementContainerToken);
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
    a(localSheet);
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
    localCellStyle.setWrapText(true);
    exportExcelSheet(localSheet, localCellStyle);
    return paramWorkbook;
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
      a(localRow.getCell(i), getFirstMember(i + 1), localCellStyle, localFormulaEvaluator);
    while (i < getConditionNum() + getValueNum())
    {
      if ((getDecisionElement(i - getConditionNum() + 1) != null) && (getDecisionElement(i - getConditionNum() + 1).getMemberElement() != null))
        a(localRow.getCell(i), getDecisionElement(i - getConditionNum() + 1).getMemberElement().getDisplayName(), localCellStyle, localFormulaEvaluator);
      else
        a(localRow.getCell(i), "", localCellStyle, localFormulaEvaluator);
      i++;
    }
    List localList = getConditions().getConditionList();
    for (int j = 0; j < localList.size(); j++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(j));
      a(paramSheet, localArrayList, localCellStyle);
    }
    for (j = 0; j < getConditionNum() + getValueNum(); j = (short)(j + 1))
      paramSheet.autoSizeColumn(j);
  }

  private void b(Sheet paramSheet)
  {
    Row localRow = paramSheet.createRow(this.b++);
    int i = 0;
    int j;
    Cell localCell;
    if (getConditionNum() > 0)
      for (j = 0; j < getConditionNum(); j++)
      {
        localCell = localRow.createCell(i++);
        localCell.setCellValue(u.a("decitioncondition.text", "condition") + (j + 1));
      }
    if (getValueNum() > 0)
      for (j = 0; j < getValueNum(); j++)
      {
        localCell = localRow.createCell(i++);
        localCell.setCellValue(u.a("decisionassign.text", "assign") + (j + 1));
      }
    if (!isEmptyAction())
      localRow.createCell(i++).setCellValue(u.a("decisionaction.text", "action"));
  }

  public void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle)
  {
    this.b = 0;
    b(paramSheet);
    Row localRow = paramSheet.createRow(this.b++);
    for (int i = 0; i < getConditionNum(); i++)
    {
      localObject = a(localRow, i, paramCellStyle);
      ((Cell)localObject).setCellValue(getFirstMember(i + 1));
    }
    while (i < getConditionNum() + getValueNum())
    {
      localObject = a(localRow, i, paramCellStyle);
      if ((getDecisionElement(i - getConditionNum() + 1) != null) && (getDecisionElement(i - getConditionNum() + 1).getMemberElement() != null))
        ((Cell)localObject).setCellValue(getDecisionElement(i - getConditionNum() + 1).getMemberElement().getDisplayName());
      else
        ((Cell)localObject).setCellValue("");
      i++;
    }
    if (!isEmptyAction())
      a(localRow, i, paramCellStyle).setCellValue("");
    Object localObject = getConditions().getConditionList();
    for (int j = 0; j < ((List)localObject).size(); j++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((List)localObject).get(j));
      a(paramSheet, localArrayList, paramCellStyle);
    }
    for (j = 0; j < getConditionNum() + getValueNum() + 1; j = (short)(j + 1))
      paramSheet.autoSizeColumn(j);
    paramSheet.createFreezePane(0, 2, 0, 2);
  }

  private void a(Sheet paramSheet, List paramList, CellStyle paramCellStyle)
  {
    if (paramList.size() < getConditionNum())
    {
      List localList = getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
      {
        b(paramSheet, paramList, paramCellStyle);
      }
      else
      {
        if ((getValueNum() == 0) && (!getDecisionAction(paramList).isEmpty()))
          b(paramSheet, paramList, paramCellStyle);
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          a(paramSheet, localArrayList, paramCellStyle);
        }
      }
    }
    else
    {
      b(paramSheet, paramList, paramCellStyle);
    }
  }

  private void a(Sheet paramSheet, List paramList, CellStyle paramCellStyle, FormulaEvaluator paramFormulaEvaluator)
  {
    if (paramList.size() < getConditionNum())
    {
      List localList = getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
      {
        b(paramSheet, paramList, paramCellStyle, paramFormulaEvaluator);
      }
      else
      {
        if ((getValueNum() == 0) && (!getDecisionAction(paramList).isEmpty()))
          b(paramSheet, paramList, paramCellStyle, paramFormulaEvaluator);
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          a(paramSheet, localArrayList, paramCellStyle, paramFormulaEvaluator);
        }
      }
    }
    else
    {
      b(paramSheet, paramList, paramCellStyle, paramFormulaEvaluator);
    }
  }

  public String getText(ILangToken paramILangToken)
  {
    String str = paramILangToken.getText();
    str = StringUtil.replace("\r", "", str);
    if (str.endsWith("\n"))
      return str.substring(0, str.length() - "\n".length());
    return str;
  }

  private void b(Sheet paramSheet, List paramList, CellStyle paramCellStyle, FormulaEvaluator paramFormulaEvaluator)
  {
    Row localRow = paramSheet.getRow(this.b++);
    for (int i = 0; i < getConditionNum(); i++)
    {
      if (paramList.size() <= i)
        continue;
      a(localRow.getCell(i), parseShortName(paramList.get(i).toString(), getFirstMember(i + 1)), paramCellStyle, paramFormulaEvaluator);
    }
    while (i < getConditionNum() + getValueNum())
    {
      if (getDecisionElement(i - getConditionNum() + 1) == null)
      {
        a(localRow.getCell(i), "", paramCellStyle, paramFormulaEvaluator);
      }
      else
      {
        localObject = getDecisionValue(paramList, getDecisionElement(i - getConditionNum() + 1).getMemberElement());
        if ((getDecisionElement(i - getConditionNum() + 1) != null) && (localObject != null))
          a(localRow.getCell(i), ((DecisionElementValue)localObject).getConstantValue(), paramCellStyle, paramFormulaEvaluator);
        else
          a(localRow.getCell(i), "", paramCellStyle, paramFormulaEvaluator);
      }
      i++;
    }
    Object localObject = getDecisionAction(paramList);
    if (!((DecisionRelateAction)localObject).isEmpty())
      a(localRow.getCell(i), getText(((DecisionRelateAction)localObject).getThenActions()), paramCellStyle, paramFormulaEvaluator);
    else
      a(localRow.getCell(i), "", paramCellStyle, paramFormulaEvaluator);
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
    Object localObject;
    while (i < getConditionNum() + getValueNum())
    {
      localCell = a(localRow, i, paramCellStyle);
      if (getDecisionElement(i - getConditionNum() + 1) == null)
      {
        localCell.setCellValue("");
      }
      else
      {
        localObject = getDecisionValue(paramList, getDecisionElement(i - getConditionNum() + 1).getMemberElement());
        if ((getDecisionElement(i - getConditionNum() + 1) != null) && (localObject != null))
          localCell.setCellValue(((DecisionElementValue)localObject).getConstantValue());
        else
          localCell.setCellValue("");
      }
      i++;
    }
    if (!isEmptyAction())
    {
      localCell = a(localRow, i, paramCellStyle);
      localObject = getDecisionAction(paramList);
      if (!((DecisionRelateAction)localObject).isEmpty())
        localCell.setCellValue(getText(((DecisionRelateAction)localObject).getThenActions()));
      else
        localCell.setCellValue("");
    }
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof DecisionRelateCondition))
    {
      Iterator localIterator1 = ((DecisionRelateCondition)paramIElement).getAcceptElements(new m(this));
      while (localIterator1.hasNext())
      {
        IConditionToken localIConditionToken = (IConditionToken)localIterator1.next();
        String str = localIConditionToken.getUuid();
        Iterator localIterator2 = getAcceptElements(new n(this, str));
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionRelateRule
 * JD-Core Version:    0.6.0
 */