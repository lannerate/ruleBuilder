package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.util.exception.UnsupportOperationException;

public class ConstantToken extends AbstractValueToken
  implements ITextEditen, IValueToken
{
  private String value = "";

  public ConstantToken()
  {
  }

  public ConstantToken(ConstantToken paramConstantToken)
  {
    super(paramConstantToken);
    this.value = paramConstantToken.value;
  }

  public ConstantToken(String paramString)
  {
    super(paramString);
  }

  public ConstantToken(String paramString1, String paramString2)
  {
    super(paramString1);
    this.value = paramString2;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitConstantToken(this);
  }

  public String getValue()
  {
    return this.value;
  }

  public boolean isEmpty()
  {
    return (this.value == null) || (this.value.length() == 0);
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public boolean checkValue(String paramString)
  {
    return getJavaType().a(paramString);
  }

  public IElement deepClone()
  {
    return new ConstantToken(this);
  }

  public String getName()
  {
    return "ConstantToken";
  }

  public String getDisplayName()
  {
    return this.value;
  }

  public String getText()
  {
    return getValue();
  }

  public void setText(String paramString)
  {
    if (!getValue().equals(paramString))
    {
      h();
      setValue(paramString);
      g();
    }
  }

  public boolean canEdit()
  {
    return true;
  }

  public String getColorType()
  {
    return "value";
  }

  public String getHint()
  {
    return "";
  }

  public String getNote()
  {
    if ((getRoot() != null) && (getRoot().getRuleTree().isDevelopModel()))
      return getValueType();
    return super.getNote();
  }

  public l[] getLeftPopupMenus()
  {
    throw new UnsupportOperationException();
  }

  public boolean hasHint()
  {
    return false;
  }

  public boolean hasLeftPopupMenus()
  {
    return false;
  }

  public String toString()
  {
    if (this.value.length() == 0)
    {
      if (getJavaType().b())
        return "0";
      return getLocalString("emptyValue.edit", "");
    }
    return super.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.ConstantToken
 * JD-Core Version:    0.6.0
 */