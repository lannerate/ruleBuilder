package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractClassToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IValueToken;

public class NewToken extends AbstractClassToken
  implements ISelectorEditen, IValueToken
{
  public NewToken(NewToken paramNewToken)
  {
    super(paramNewToken);
  }

  public NewToken(String paramString)
  {
    super(paramString);
  }

  public NewToken()
  {
  }

  public IElement deepClone()
  {
    return new NewToken(this);
  }

  public String getName()
  {
    return "NewToken";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitNewToken(this);
  }

  public String getColorType()
  {
    return "classConstructor";
  }

  public String getHint()
  {
    return getLocalString("newClass.text");
  }

  public boolean hasHint()
  {
    return true;
  }

  public String toString()
  {
    return getHint() + getDisplayName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.NewToken
 * JD-Core Version:    0.6.0
 */