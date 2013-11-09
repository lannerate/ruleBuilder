package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.util.exception.UnsupportOperationException;

public class JavaStatementToken extends AbstractRuleObject
  implements ITextEditen, IStatementToken
{
  private String value = "";
  public static final String JAVAINFO = "java:";

  public JavaStatementToken()
  {
  }

  public JavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    super(paramJavaStatementToken);
    this.value = paramJavaStatementToken.value;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitJavaStatementToken(this);
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public IElement deepClone()
  {
    return new JavaStatementToken(this);
  }

  public String getName()
  {
    return "JavaStatementToken";
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

  public boolean checkValue(String paramString)
  {
    return true;
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.JavaStatementToken
 * JD-Core Version:    0.6.0
 */