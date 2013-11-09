package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.lang.expression.j;
import com.flagleader.repository.lang.expression.w;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.NumberOperatorToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiConditionToken extends AbstractRuleObject
  implements IMultiLineEditen, IMultiConditionToken
{
  protected static final String ADDCONDITION = "&addCondition";
  protected static final String REMOVECONDITION = "&remove";
  protected transient ModifyToken a = null;
  private int type = 0;
  private transient com.flagleader.repository.o undoable = null;

  public Iterator getMultiLine()
  {
    ArrayList localArrayList = new ArrayList();
    com.flagleader.repository.d.o.a(localArrayList, getConditions());
    if (!getRoot().isLocked())
      localArrayList.add(getConditionModifyToken());
    return localArrayList.iterator();
  }

  protected ConditionToken d()
  {
    ConditionToken localConditionToken = new ConditionToken();
    localConditionToken.init();
    addChildElement(localConditionToken);
    return localConditionToken;
  }

  public MultiConditionToken()
  {
  }

  public MultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    super(paramMultiConditionToken);
    this.type = paramMultiConditionToken.type;
  }

  public MultiConditionToken(int paramInt)
  {
    this.type = paramInt;
  }

  public ModifyToken getConditionModifyToken()
  {
    if (this.a == null)
      setConditionModifyToken(new MultiConditionToken.AppendToken(this, "&addCondition", new q(this)));
    return this.a;
  }

  public void setConditionModifyToken(ModifyToken paramModifyToken)
  {
    this.a = paramModifyToken;
    this.a.setParent(this);
  }

  public Iterator getConditions()
  {
    return f().iterator();
  }

  public List getConditionList()
  {
    return f();
  }

  private List f()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IConditionToken))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public IConditionToken getCondition(int paramInt)
  {
    List localList = f();
    if ((paramInt < localList.size()) && (paramInt >= 0))
      return (IConditionToken)localList.get(paramInt);
    return null;
  }

  public String parseShortName(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1))
      return paramString1;
    if (paramString1.trim().startsWith(paramString2))
    {
      String str = StringUtil.replace(paramString2 + u.a("EqualsTo.edit", "equals to "), "", paramString1.trim()).trim();
      str = StringUtil.replace(u.a("notNary.edit") + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("isNary.edit") + paramString2, u.a("notNary.edit"), str);
      if (str.startsWith(paramString2))
        return str.substring(paramString2.length());
      return str;
    }
    return paramString1.trim();
  }

  public IConditionToken findCondition(IBusinessObject paramIBusinessObject, String paramString, StatementSystem paramStatementSystem)
  {
    Object localObject1 = null;
    Iterator localIterator = getChildrenIterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      if (!(localObject2 instanceof IConditionToken))
        continue;
      localObject3 = (IConditionToken)localObject2;
      localObject4 = "";
      if ((((IConditionToken)localObject3).getCompareOperator().getType() == 0) && (!((IConditionToken)localObject3).getNextTests().hasNext()))
      {
        if (((IConditionToken)localObject3).getComparedValue() != null)
          localObject4 = ((IConditionToken)localObject3).getComparedValue().toString();
        else
          localObject4 = "";
      }
      else
        localObject4 = parseShortName(localObject3.toString(), paramIBusinessObject.getDisplayName());
      if (!((String)localObject4).trim().equals(paramString))
        continue;
      localObject1 = localObject3;
      break;
    }
    if (localObject1 == null)
    {
      localObject2 = paramStatementSystem.g(paramString);
      localObject3 = e();
      localObject4 = (MemberToken)((ConditionToken)localObject3).getFirstValue();
      ((MemberToken)localObject4).setValueType(paramIBusinessObject.getValueType());
      ((MemberToken)localObject4).setMemberElement(paramIBusinessObject);
      ArrayList localArrayList = ((j)localObject2).b();
      if (localArrayList.size() > 0)
        ((w)localArrayList.get(0)).a((ConditionToken)localObject3);
      if (localArrayList.size() > 1)
      {
        Object localObject5 = localObject3;
        for (int i = 1; i < localArrayList.size(); i++)
        {
          ConditionToken localConditionToken = new ConditionToken();
          localConditionToken.init();
          localObject5.addChildElement(localConditionToken);
          ((MemberToken)localConditionToken.getFirstValue()).setValueType(paramIBusinessObject.getValueType());
          ((MemberToken)localConditionToken.getFirstValue()).setMemberElement(paramIBusinessObject);
          ((w)localArrayList.get(i)).a(localConditionToken);
        }
      }
      return localObject3;
    }
    return (IConditionToken)(IConditionToken)(IConditionToken)localObject1;
  }

  private void a(IElement paramIElement, String paramString1, String paramString2)
  {
    NumberOperatorToken localNumberOperatorToken = new NumberOperatorToken();
    Object localObject1;
    Object localObject2;
    for (int i = localNumberOperatorToken.getCount() - 1; i > 0; i--)
    {
      int j = paramString1.indexOf(localNumberOperatorToken.getTypeName(i));
      if (j < 0)
        j = paramString1.indexOf(localNumberOperatorToken.getLanguageName(i));
      if (j <= 0)
        continue;
      localObject1 = paramString1.substring(0, j);
      if (NumberUtil.isParsedPercent((String)localObject1))
      {
        localObject2 = new ValueToken(2, paramString2, "");
        paramIElement.addChildElement((IElement)localObject2);
        ((ValueToken)localObject2).setFieldType(2);
        if (((String)localObject1).equals(getLocalString("emptyValue.edit", "")))
          localObject1 = "";
        ((ConstantToken)((ValueToken)localObject2).getValueElement()).setValue((String)localObject1);
        ((ValueToken)localObject2).getOperator().setType(i);
        a((IElement)localObject2, paramString1.substring(j + localNumberOperatorToken.getTypeName(i).length()), paramString2);
      }
      else
      {
        localObject2 = new ValueToken(1, paramString2, "");
        paramIElement.addChildElement((IElement)localObject2);
        ((ValueToken)localObject2).setFieldType(1);
        IPackageElement localIPackageElement = ((ValueToken)localObject2).getRoot().getRuleTree();
        if ((localIPackageElement instanceof IRuleTree))
        {
          IBusinessObject localIBusinessObject = ((IRuleTree)localIPackageElement).getBusinessObject((String)localObject1);
          if (localIBusinessObject != null)
            ((MemberToken)((ValueToken)localObject2).getValueElement()).setMemberElement(localIBusinessObject);
        }
        else
        {
          ((MemberToken)((ValueToken)localObject2).getValueElement()).setUniqueName((String)localObject1);
        }
        ((ValueToken)localObject2).getOperator().setType(i);
        a((IElement)localObject2, paramString1.substring(j + localNumberOperatorToken.getTypeName(i).length()), paramString2);
      }
      return;
    }
    String str = paramString1;
    ValueToken localValueToken;
    if (NumberUtil.isParsedPercent(str))
    {
      localValueToken = new ValueToken(2, paramString2, "");
      paramIElement.addChildElement(localValueToken);
      localValueToken.setFieldType(2);
      if (str.equals(getLocalString("emptyValue.edit", "")))
        str = "";
      ((ConstantToken)localValueToken.getValueElement()).setValue(str);
    }
    else
    {
      localValueToken = new ValueToken(1, paramString2, "");
      paramIElement.addChildElement(localValueToken);
      localValueToken.setFieldType(1);
      localObject1 = localValueToken.getRoot().getRuleTree();
      if ((localObject1 instanceof IRuleTree))
      {
        localObject2 = ((IRuleTree)localObject1).getBusinessObject(str);
        if (localObject2 != null)
          ((MemberToken)localValueToken.getValueElement()).setMemberElement((IElement)localObject2);
      }
      else
      {
        ((MemberToken)localValueToken.getValueElement()).setUniqueName(str);
      }
    }
  }

  protected ConditionToken e()
  {
    ConditionToken localConditionToken = new ConditionToken();
    localConditionToken.init();
    addChildElement(localConditionToken);
    return localConditionToken;
  }

  public IValueToken getSameFirstValue()
  {
    IValueToken localIValueToken = null;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IConditionToken))
        continue;
      if (localIValueToken == null)
        localIValueToken = ((IConditionToken)localObject).getFirstValue();
      else if (!localIValueToken.getDisplayName().equals(((IConditionToken)localObject).getFirstValue().getDisplayName()))
        return null;
    }
    return localIValueToken;
  }

  public int getConditionPos(IConditionToken paramIConditionToken)
  {
    List localList = f();
    return localList.indexOf(paramIConditionToken);
  }

  public IConditionToken getNextCondition(IConditionToken paramIConditionToken)
  {
    return getCondition(getConditionPos(paramIConditionToken) + 1);
  }

  public IConditionToken getPreviousCondition(IConditionToken paramIConditionToken)
  {
    return getCondition(getConditionPos(paramIConditionToken) - 1);
  }

  public String getName()
  {
    return "MultiConditionToken";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMultiConditionToken(this);
  }

  public IElement deepClone()
  {
    return new MultiConditionToken(this);
  }

  public int getType()
  {
    return this.type;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return (paramIElement != null) && (((paramIElement instanceof ConditionToken)) || ((paramIElement instanceof ElementContainer)) || ((paramIElement instanceof IBusinessObject))) && (getParent() != null);
  }

  public boolean paste(IElement paramIElement)
  {
    return pasteElement(paramIElement);
  }

  public boolean pasteElement(IElement paramIElement)
  {
    if (canPasteElement(paramIElement))
    {
      h();
      if ((paramIElement instanceof ConditionToken))
      {
        addChildElement(paramIElement);
      }
      else
      {
        Object localObject1;
        Object localObject2;
        if ((paramIElement instanceof ElementContainer))
        {
          localObject1 = ((ElementContainer)paramIElement).getChildrenIterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if ((localObject2 instanceof ConditionToken))
            {
              addChildElement((ConditionToken)localObject2);
            }
            else
            {
              if (!(localObject2 instanceof StatementContainerToken))
                continue;
              if ((getParent() instanceof ElseIfRuleToken))
              {
                ((ElseIfRuleToken)getParent()).getThenActions().addChildElement((StatementContainerToken)localObject2);
              }
              else
              {
                if (!(getParent() instanceof RuleToken))
                  continue;
                ((RuleToken)getParent()).getThenActions().addChildElement((StatementContainerToken)localObject2);
              }
            }
          }
        }
        else if (((paramIElement instanceof IBusinessObject)) && ((((IBusinessObject)paramIElement).getJavaType().b()) || (((IBusinessObject)paramIElement).getJavaType().G()) || (((IBusinessObject)paramIElement).getJavaType().j()) || (((IBusinessObject)paramIElement).getJavaType().m()) || (((IBusinessObject)paramIElement).getJavaType().e())))
        {
          localObject1 = d();
          localObject2 = ((ConditionToken)localObject1).getFirstValue();
          if ((localObject2 instanceof MemberToken))
          {
            ((MemberToken)localObject2).setMemberElement((IBusinessObject)paramIElement);
            IValueContainerToken localIValueContainerToken = ((ConditionToken)localObject1).getComparedValue();
            if ((localIValueContainerToken != null) && ((localIValueContainerToken instanceof ValueToken)) && (((ValueToken)localIValueContainerToken).getValueElement() == null))
              ((ValueToken)localIValueContainerToken).setFieldType(2);
          }
        }
      }
      g();
      return true;
    }
    return false;
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public IElement copyElement()
  {
    return null;
  }

  public IElement cutElement()
  {
    return null;
  }

  public com.flagleader.repository.o getUndoable()
  {
    if (this.undoable == null)
      this.undoable = new com.flagleader.repository.o(this);
    return this.undoable;
  }

  public boolean canRedo()
  {
    return getUndoable().canRedo();
  }

  public boolean canUndo()
  {
    return getUndoable().canUndo();
  }

  public boolean redo()
  {
    return getUndoable().redo();
  }

  public void takeSnapshot()
  {
    getUndoable().a(true);
    getUndoable().takeSnapshot();
    getUndoable().a(false);
  }

  public boolean undo()
  {
    return getUndoable().undo();
  }

  public void initUndoable()
  {
    getUndoable().initUndoable();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.MultiConditionToken
 * JD-Core Version:    0.6.0
 */