package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.util.exception.UnsupportOperationException;

public class ReturnToken extends AbstractRuleObject
  implements ISelectorEditen, IStatementToken
{
  public static final int THISRULE = 0;
  public static final int PARENTSET = 1;
  public static final int ALLSET = 2;
  public static final int RESTART = 3;
  private static final String[] messages = { "&thisRule", "&parentSet", "&mainSet", "&reStart" };
  private int returnType = 2;
  private transient l[] popupMessages = null;

  public ReturnToken(ReturnToken paramReturnToken)
  {
    super(paramReturnToken);
    this.returnType = paramReturnToken.returnType;
  }

  public ReturnToken()
  {
  }

  protected void d()
  {
    this.popupMessages = new l[4];
    for (int i = 0; i < 4; i++)
    {
      String str = getLocalString(messages[i].substring(1) + ".edit", messages[i].substring(1));
      this.popupMessages[i] = new l(str, new t(this, i), null);
    }
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitReturnToken(this);
  }

  public IElement deepClone()
  {
    return new ReturnToken(this);
  }

  public String getName()
  {
    return "ReturnToken";
  }

  public String getColorType()
  {
    return "return";
  }

  public String getHint()
  {
    return getLocalString("return.edit");
  }

  public boolean hasHint()
  {
    return false;
  }

  public int getReturnType()
  {
    return this.returnType;
  }

  public void setReturnType(int paramInt)
  {
    this.returnType = paramInt;
  }

  public boolean canEdit()
  {
    return false;
  }

  public l[] getLeftPopupMenus()
  {
    if (this.popupMessages == null)
      d();
    return this.popupMessages;
  }

  public String getText()
  {
    throw new UnsupportOperationException();
  }

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public void setText(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public String getDisplayName()
  {
    return getLocalString(messages[this.returnType].substring(1) + ".edit", messages[this.returnType]);
  }

  public String toString()
  {
    return getHint() + getDisplayName();
  }

  public IElement getBusinessObject()
  {
    return null;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return false;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.ReturnToken
 * JD-Core Version:    0.6.0
 */