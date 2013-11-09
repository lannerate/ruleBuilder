package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExeRuleToken extends AbstractRuleObject
  implements IMultiEditen, IStatementToken
{
  ExeRuleToken.ExcuteTypeSelector a;
  public static final int EXCUTELOCAL = 0;
  public static final int EXCUTEEXITS = 1;
  public static final int EXCUTELOCALSYN = 2;
  public static final int EXCUTEEXITSSYN = 3;
  private static final String[] messages = { "&excuteAndExits", "&excuteNotExits", "&excuteAndExitsThread", "&excuteNotExitsThread" };
  private int returnType = 0;
  private transient l[] popupMessages = null;

  public ExeRuleToken()
  {
  }

  public ExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    super(paramExeRuleToken);
    this.returnType = paramExeRuleToken.returnType;
  }

  protected void d()
  {
    this.popupMessages = new l[4];
    for (int i = 0; i < 4; i++)
    {
      String str = getLocalString(messages[i].substring(1) + ".edit", messages[i].substring(1));
      this.popupMessages[i] = new l(str, new j(this, i), null);
    }
  }

  public ExeRuleToken init()
  {
    SelectRulePackageToken localSelectRulePackageToken = new SelectRulePackageToken();
    addChildElement(localSelectRulePackageToken);
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExeRuleToken(this);
  }

  public IElement deepClone()
  {
    return new ExeRuleToken(this);
  }

  public String getName()
  {
    return "ExeRuleToken";
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
    return ((paramIElement instanceof IVariableToken)) || ((paramIElement instanceof SelectRulePackageToken));
  }

  public SelectRulePackageToken getRuleNameToken()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof SelectRulePackageToken))
        return (SelectRulePackageToken)localObject;
    }
    return null;
  }

  private ExeRuleToken.ExcuteTypeSelector e()
  {
    if (this.a == null)
      this.a = new ExeRuleToken.ExcuteTypeSelector(this);
    return this.a;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(e());
    localArrayList.add(getRuleNameToken());
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

  public String getColorType()
  {
    return "rulepackage";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.ExeRuleToken
 * JD-Core Version:    0.6.0
 */