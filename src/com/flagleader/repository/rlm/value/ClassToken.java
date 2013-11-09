package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractClassToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IClassObject;

public class ClassToken extends AbstractClassToken
  implements ISelectorEditen, IValueToken
{
  public ClassToken()
  {
  }

  public ClassToken(String paramString)
  {
    super(paramString);
  }

  public ClassToken(ClassToken paramClassToken)
  {
    super(paramClassToken);
  }

  public String getName()
  {
    return "ClassToken";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitClassToken(this);
  }

  public IElement deepClone()
  {
    return new ClassToken(this);
  }

  public IClassObject getClassMember()
  {
    return (IClassObject)getMemberElement();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.ClassToken
 * JD-Core Version:    0.6.0
 */