package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rlm.value.ValueToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogRecordToken extends AbstractRuleObject
  implements IMultiEditen, IStatementToken
{
  LogRecordToken.LogTypeSelector a;
  public static final int LOGERROR = 0;
  public static final int LOGWARNING = 1;
  public static final int LOGINFO = 2;
  public static final int LOGDEBUG = 3;
  private static final String[] messages = { "&logError", "&logWarning", "&logInfo", "&logDebug" };
  private int returnType = 0;
  private transient l[] popupMessages = null;

  public LogRecordToken()
  {
  }

  public LogRecordToken(LogRecordToken paramLogRecordToken)
  {
    super(paramLogRecordToken);
    this.returnType = paramLogRecordToken.returnType;
  }

  protected void d()
  {
    this.popupMessages = new l[4];
    for (int i = 0; i < 4; i++)
    {
      String str = getLocalString(messages[i].substring(1) + ".edit", messages[i].substring(1));
      this.popupMessages[i] = new l(str, new q(this, i), null);
    }
  }

  public LogRecordToken init()
  {
    ValueToken localValueToken = new ValueToken(2, "string", "");
    localValueToken.setFieldType(2);
    addChildElement(localValueToken);
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitLogRecordToken(this);
  }

  public IElement deepClone()
  {
    return new LogRecordToken(this);
  }

  public String getName()
  {
    return "LogRecordToken";
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

  private LogRecordToken.LogTypeSelector e()
  {
    if (this.a == null)
      this.a = new LogRecordToken.LogTypeSelector(this);
    return this.a;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(e());
    if (getComparedValue() != null)
      localArrayList.add(getComparedValue());
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
 * Qualified Name:     com.flagleader.repository.rlm.action.LogRecordToken
 * JD-Core Version:    0.6.0
 */