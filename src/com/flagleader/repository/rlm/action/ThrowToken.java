package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rlm.value.ValueToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThrowToken extends AbstractRuleObject
  implements IMultiEditen, IStatementToken
{
  public static final String THROWINFO = getLocalString("throw.text");

  public ThrowToken(ThrowToken paramThrowToken)
  {
    super(paramThrowToken);
  }

  public ThrowToken()
  {
  }

  public ThrowToken init()
  {
    ValueToken localValueToken = new ValueToken(2, "string", "");
    localValueToken.setFieldType(2);
    addChildElement(localValueToken);
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitThrowToken(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IVariableToken)) || ((paramIElement instanceof IValueContainerToken));
  }

  public IValueContainerToken getErrorValue()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((localObject instanceof IValueContainerToken))
        return (IValueContainerToken)localObject;
    }
    Object localObject = new ValueToken(2, "string", "");
    ((ValueToken)localObject).setFieldType(2);
    addChildElement((IElement)localObject);
    return (IValueContainerToken)localObject;
  }

  public void addChildElement(IElement paramIElement)
  {
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      IElement localIElement = getElement(i);
      if ((!(paramIElement instanceof IValueContainerToken)) || (!(localIElement instanceof IValueContainerToken)))
        continue;
      removeChildElement(localIElement);
    }
    super.addChildElement(paramIElement);
  }

  public IElement deepClone()
  {
    return new ThrowToken(this);
  }

  public String getName()
  {
    return "ThrowToken";
  }

  public boolean canEdit()
  {
    return true;
  }

  public String getHint()
  {
    return THROWINFO;
  }

  public l[] getLeftPopupMenus()
  {
    return new l[0];
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new StaticTextToken(getHint(), "throw"));
    if (getErrorValue() != null)
      localArrayList.add(getErrorValue());
    return localArrayList.iterator();
  }

  public String getColorType()
  {
    return "throw";
  }

  public String getText()
  {
    return getDisplayName();
  }

  public boolean hasHint()
  {
    return true;
  }

  public boolean hasLeftPopupMenus()
  {
    return false;
  }

  public void setText(String paramString)
  {
    if (!getDisplayName().equals(paramString))
    {
      h();
      setDisplayName(paramString);
      g();
    }
  }

  public boolean checkValue(String paramString)
  {
    return true;
  }

  public String toString()
  {
    return getHint() + getDisplayName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.ThrowToken
 * JD-Core Version:    0.6.0
 */