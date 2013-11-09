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

public class ExcuteRuleToken extends AbstractRuleObject
  implements IMultiEditen, IStatementToken
{
  ExcuteRuleToken.ExcuteTypeSelector a;
  public static final int EXCUTELOCAL = 0;
  public static final int EXCUTEEXITS = 1;
  public static final int EXCUTESERVER = 2;
  public static final int EXCUTESERVICE = 3;
  private static final String[] messages = { "&excuteLocal", "&excuteExits", "&excuteServer", "&excuteService" };
  private int returnType = 0;
  private transient l[] popupMessages = null;

  public ExcuteRuleToken()
  {
  }

  public ExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    super(paramExcuteRuleToken);
    this.returnType = paramExcuteRuleToken.returnType;
  }

  protected void d()
  {
    this.popupMessages = new l[4];
    for (int i = 0; i < 4; i++)
    {
      String str = getLocalString(messages[i].substring(1) + ".edit", messages[i].substring(1));
      this.popupMessages[i] = new l(str, new g(this, i), null);
    }
  }

  public ExcuteRuleToken init()
  {
    ValueToken localValueToken = new ValueToken(2, "string", "name");
    localValueToken.setFieldType(2);
    addChildElement(localValueToken);
    localValueToken = new ValueToken(2, "string", "ver");
    localValueToken.setFieldType(2);
    addChildElement(localValueToken);
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcuteRuleToken(this);
  }

  public IElement deepClone()
  {
    return new ExcuteRuleToken(this);
  }

  public String getName()
  {
    return "ExcuteRuleToken";
  }

  public int getReturnType()
  {
    return this.returnType;
  }

  public void setReturnType(int paramInt)
  {
    this.returnType = paramInt;
  }

  public l[] getLeftPopupMenus()
  {
    if (this.popupMessages == null)
      d();
    return this.popupMessages;
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IVariableToken)) || ((paramIElement instanceof IValueContainerToken));
  }

  public IValueContainerToken getRuleNameToken()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ValueToken)) && (((ValueToken)localObject).getArgName().equalsIgnoreCase("name")))
        return (IValueContainerToken)localObject;
    }
    return null;
  }

  public IValueContainerToken getRuleVersionToken()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ValueToken)) && (((ValueToken)localObject).getArgName().equalsIgnoreCase("ver")))
        return (IValueContainerToken)localObject;
    }
    return null;
  }

  private ExcuteRuleToken.ExcuteTypeSelector e()
  {
    if (this.a == null)
      this.a = new ExcuteRuleToken.ExcuteTypeSelector(this);
    return this.a;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(e());
    localArrayList.add(getRuleNameToken());
    localArrayList.add(new StaticTextToken(getLocalString("excuteVersion.edit", ",Version"), "rulepackage"));
    localArrayList.add(getRuleVersionToken());
    return localArrayList.iterator();
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
 * Qualified Name:     com.flagleader.repository.rlm.action.ExcuteRuleToken
 * JD-Core Version:    0.6.0
 */