package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IAssignToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IPropertyObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AssignToken extends AbstractRuleObject
  implements IMultiEditen, IStatementToken
{
  public AssignToken()
  {
  }

  public AssignToken(AssignToken paramAssignToken)
  {
    super(paramAssignToken);
  }

  public AssignToken init()
  {
    addChildElement(new FieldToken());
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitAssignToken(this);
  }

  public IElement deepClone()
  {
    return new AssignToken(this);
  }

  public String getName()
  {
    return "AssignToken";
  }

  public void changeFieldType(g paramg)
  {
    if ((getAssign() != null) && ((getFirstValue() instanceof MemberToken)) && ((((MemberToken)getFirstValue()).getMemberElement() instanceof IPropertyObject)))
    {
      if (((getAssign() instanceof StringAssignJudgeToken)) && (!paramg.m()))
        removeChildElement(getAssign());
      if (((getAssign() instanceof NumberAssignJudgeToken)) && (!paramg.b()) && (!paramg.j()))
        removeChildElement(getAssign());
      if (((getAssign() instanceof AssignJudgeToken)) && ((paramg.m()) || (paramg.b()) || (paramg.j())))
        removeChildElement(getAssign());
    }
    if (getAssign() == null)
      if (((getFirstValue() instanceof MemberToken)) && ((((MemberToken)getFirstValue()).getMemberElement() instanceof IPropertyObject)))
        addChildElement(new AssignJudgeToken());
      else if (paramg.m())
        addChildElement(new StringAssignJudgeToken());
      else if ((paramg.b()) || (paramg.j()))
        addChildElement(new NumberAssignJudgeToken());
      else
        addChildElement(new AssignJudgeToken());
    if ((getComparedValue() != null) && (!paramg.a(getComparedValue().getJavaType(), false)))
      removeChildElement(getComparedValue());
    if (getComparedValue() == null)
      if ((paramg.b()) || (paramg.j()) || (paramg.m()) || (paramg.d()))
        addChildElement(new ValueToken(2, paramg.K(), ""));
      else
        addChildElement(new ValueToken(1, paramg.K(), ""));
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IVariableToken)) || ((paramIElement instanceof IValueContainerToken)) || ((paramIElement instanceof IAssignToken));
  }

  public IValueContainerToken getComparedValue()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IValueContainerToken))
        return (IValueContainerToken)localObject;
    }
    return null;
  }

  public IVariableToken getFirstValue()
  {
    Iterator localIterator = getChildrenIterator();
    FieldToken localFieldToken = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof FieldToken))
        continue;
      localFieldToken = (FieldToken)localObject;
      break;
    }
    return localFieldToken;
  }

  public IAssignToken getAssign()
  {
    Iterator localIterator = getChildrenIterator();
    IAssignToken localIAssignToken = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IAssignToken))
        continue;
      localIAssignToken = (IAssignToken)localObject;
      break;
    }
    return localIAssignToken;
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof FieldToken))
      ((FieldToken)paramIElement).addElementTokenListener(new f(this));
    b(paramIElement);
    super.addChildElement(paramIElement);
  }

  private void b(IElement paramIElement)
  {
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      IElement localIElement = getElement(i);
      if (((paramIElement instanceof FieldToken)) && ((localIElement instanceof FieldToken)))
      {
        removeChildElement(localIElement);
      }
      else if (((paramIElement instanceof IValueContainerToken)) && ((localIElement instanceof IValueContainerToken)))
      {
        removeChildElement(localIElement);
      }
      else
      {
        if ((!(paramIElement instanceof IAssignToken)) || (!(localIElement instanceof IAssignToken)))
          continue;
        removeChildElement(localIElement);
      }
    }
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(3);
    if (getFirstValue() != null)
      localArrayList.add(getFirstValue());
    if (getAssign() != null)
      localArrayList.add(getAssign());
    if (getComparedValue() != null)
      localArrayList.add(getComparedValue());
    return localArrayList.iterator();
  }

  public void changeValueType(String paramString)
  {
    g localg = getTypeManager().a(paramString);
    if (getFirstValue() != null)
      getFirstValue().setValueType(paramString);
    if ((getAssign() != null) && ((!(getFirstValue() instanceof MemberToken)) || (!(((MemberToken)getFirstValue()).getMemberElement() instanceof IPropertyObject))))
    {
      int i = getAssign().getType();
      if (((getAssign() instanceof StringAssignJudgeToken)) && (!localg.m()))
        removeChildElement(getAssign());
      if (((getAssign() instanceof NumberAssignJudgeToken)) && (!localg.b()) && (!localg.j()))
        removeChildElement(getAssign());
      if (((getAssign() instanceof AssignJudgeToken)) && ((localg.m()) || (localg.b()) || (localg.j())))
        removeChildElement(getAssign());
      if (getAssign() == null)
        if (localg.m())
          addChildElement(new StringAssignJudgeToken(i));
        else if ((localg.b()) || (localg.j()))
          addChildElement(new NumberAssignJudgeToken(i));
        else
          addChildElement(new AssignJudgeToken(i));
    }
    if (getComparedValue() != null)
      getComparedValue().changeValueType(paramString);
  }

  public String toString()
  {
    Iterator localIterator = getMultiToken();
    StringBuffer localStringBuffer = new StringBuffer();
    while (localIterator.hasNext())
      localStringBuffer.append(localIterator.next());
    return localStringBuffer.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.AssignToken
 * JD-Core Version:    0.6.0
 */