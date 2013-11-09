package com.flagleader.repository.rlm.action;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.o;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiActionToken extends AbstractRuleObject
  implements IMultiLineEditen, IMultiActionToken
{
  private static final String ADDACTION = "&addAction";
  private transient ModifyToken actionModifyToken = null;
  private int type = 0;

  protected StatementContainerToken d()
  {
    StatementContainerToken localStatementContainerToken = new StatementContainerToken();
    addChildElement(localStatementContainerToken);
    return localStatementContainerToken;
  }

  public MultiActionToken()
  {
  }

  public MultiActionToken(int paramInt)
  {
    this.type = paramInt;
  }

  public MultiActionToken(MultiActionToken paramMultiActionToken)
  {
    super(paramMultiActionToken);
    this.type = paramMultiActionToken.type;
  }

  public Iterator getActions()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IStatementContainerToken))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList.iterator();
  }

  public List getAllExeExpressionToken()
  {
    Iterator localIterator = getAcceptElements(new r(this));
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return localArrayList;
  }

  public boolean addVariableInit(IVariableObject paramIVariableObject)
  {
    if (paramIVariableObject != null)
    {
      StatementContainerToken localStatementContainerToken = new StatementContainerToken();
      addChildElement(localStatementContainerToken, getChildrenCount());
      AssignToken localAssignToken = new AssignToken();
      localStatementContainerToken.addChildElement(localAssignToken);
      FieldToken localFieldToken = new FieldToken();
      localAssignToken.addChildElement(localFieldToken);
      localFieldToken.setMemberElement(paramIVariableObject);
      ValueToken localValueToken = new ValueToken(2, paramIVariableObject.getValueType(), "");
      localAssignToken.addChildElement(localValueToken);
      ConstantToken localConstantToken = new ConstantToken(paramIVariableObject.getValueType());
      if (paramIVariableObject.getJavaType().b())
        localConstantToken.setValue("0");
      else
        localConstantToken.setValue("");
      localValueToken.addChildElement(localConstantToken);
      localAssignToken.changeValueType(paramIVariableObject.getValueType());
      return true;
    }
    return false;
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    if (paramIVariableObject != null)
    {
      StatementContainerToken localStatementContainerToken = new StatementContainerToken();
      addChildElement(localStatementContainerToken, getChildrenCount());
      DebugToken localDebugToken = new DebugToken();
      localStatementContainerToken.addChildElement(localDebugToken);
      ValueToken localValueToken = new ValueToken(1, "string", "");
      localDebugToken.addChildElement(localValueToken);
      ConstantToken localConstantToken = new ConstantToken("string");
      localConstantToken.setValue(getRoot().toString() + " : " + paramIVariableObject.getShowDisplayName() + " = ");
      localValueToken.addChildElement(localConstantToken);
      localValueToken.getOperator().setType(1);
      MemberToken localMemberToken = new MemberToken(paramIVariableObject.getValueType());
      localValueToken.getNextValue().addChildElement(localMemberToken);
      localMemberToken.setMemberElement(paramIVariableObject);
      return true;
    }
    return false;
  }

  public boolean clearDebug()
  {
    int i = 0;
    List localList = a();
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if ((!(localList.get(j) instanceof StatementContainerToken)) || (!(((StatementContainerToken)localList.get(j)).getStatement() instanceof DebugToken)))
        continue;
      ((StatementContainerToken)localList.get(j)).dispose();
      i = 1;
    }
    return i;
  }

  public ModifyToken getActionModifyToken()
  {
    if (this.actionModifyToken == null)
      setActionModifyToken(new MultiActionToken.AppendToken(this, "&addAction", new s(this, null)));
    return this.actionModifyToken;
  }

  public void setActionModifyToken(ModifyToken paramModifyToken)
  {
    this.actionModifyToken = paramModifyToken;
    this.actionModifyToken.setParent(this);
  }

  public String getName()
  {
    return "MultiActionToken";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMultiActionToken(this);
  }

  public IElement deepClone()
  {
    return new MultiActionToken(this);
  }

  public Iterator getMultiLine()
  {
    ArrayList localArrayList = new ArrayList();
    o.a(localArrayList, getActions());
    if (!getRoot().isLocked())
      localArrayList.add(getActionModifyToken());
    return localArrayList.iterator();
  }

  public boolean isInitAction()
  {
    return (this.type == 1) || (this.type == 2);
  }

  public int getType()
  {
    return this.type;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
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

  public boolean canPasteElement(IElement paramIElement)
  {
    return (paramIElement != null) && (((paramIElement instanceof StatementContainerToken)) || ((paramIElement instanceof ElementContainer)) || ((paramIElement instanceof IVariableObject)) || ((paramIElement instanceof IFunctionObject))) && (getParent() != null);
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
      if ((paramIElement instanceof StatementContainerToken))
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
            if (!(localObject2 instanceof StatementContainerToken))
              continue;
            addChildElement((StatementContainerToken)localObject2);
          }
        }
        else if ((paramIElement instanceof IVariableObject))
        {
          localObject1 = d();
          localObject2 = new AssignToken().init();
          ((StatementContainerToken)localObject1).addChildElement((IElement)localObject2);
          if (((FieldToken)((AssignToken)localObject2).getFirstValue()).acceptBusinessObject(paramIElement))
          {
            ((FieldToken)((AssignToken)localObject2).getFirstValue()).setMemberElement((IVariableObject)paramIElement);
            IValueContainerToken localIValueContainerToken = ((AssignToken)localObject2).getComparedValue();
            if ((localIValueContainerToken != null) && ((localIValueContainerToken instanceof ValueToken)) && (((ValueToken)localIValueContainerToken).getValueElement() == null))
              ((ValueToken)localIValueContainerToken).setFieldType(2);
          }
        }
        else if ((paramIElement instanceof IFunctionObject))
        {
          localObject1 = d();
          localObject2 = new MethodToken();
          ((StatementContainerToken)localObject1).addChildElement((IElement)localObject2);
          if (((MethodToken)localObject2).acceptBusinessObject(paramIElement))
            ((MethodToken)localObject2).setMemberElement((IFunctionObject)paramIElement);
          g();
          update();
        }
      }
      g();
      return true;
    }
    return false;
  }

  public boolean hasTwoReturnToken()
  {
    int i = 0;
    Iterator localIterator = getActions();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
        i++;
      if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
        continue;
      i++;
    }
    return i > 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.MultiActionToken
 * JD-Core Version:    0.6.0
 */