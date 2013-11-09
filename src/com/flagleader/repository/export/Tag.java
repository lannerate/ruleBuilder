package com.flagleader.repository.export;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tag extends AbstractElement
{
  private String name = "";
  private String disName = "";
  private String preCode = "";
  private String postCode = "";

  public Tag()
  {
  }

  public Tag(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.disName = paramString2;
  }

  public Tag(Tag paramTag)
  {
    super(paramTag);
    this.name = paramTag.name;
    this.disName = paramTag.disName;
    this.preCode = paramTag.preCode;
    this.postCode = paramTag.postCode;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new Tag(this);
  }

  public List getAttributes()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int j;
    for (int i = this.preCode.indexOf("$"); i > 0; i = this.preCode.indexOf("$", j + 1))
    {
      j = this.preCode.indexOf("$", i + 1);
      if (j <= i)
        break;
      String str = this.preCode.substring(i + 1, j);
      if (localHashMap.get(str) != null)
        continue;
      localArrayList.add(str);
      localHashMap.put(str, str);
    }
    return localArrayList;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public String getPostCode()
  {
    return this.postCode;
  }

  public void setPostCode(String paramString)
  {
    this.postCode = paramString;
  }

  public String getPreCode()
  {
    return this.preCode;
  }

  public void setPreCode(String paramString)
  {
    this.preCode = paramString;
  }

  public String getDisName()
  {
    if (this.disName.length() == 0)
      return getName();
    return this.disName;
  }

  public void setDisName(String paramString)
  {
    this.disName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.Tag
 * JD-Core Version:    0.6.0
 */