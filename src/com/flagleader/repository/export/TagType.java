package com.flagleader.repository.export;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.List;

public class TagType extends AbstractElement
{
  private String name = "";
  private String disName = "";

  public TagType()
  {
  }

  public TagType(TagType paramTagType)
  {
    super(paramTagType);
    this.name = paramTagType.name;
    this.disName = paramTagType.disName;
  }

  public TagType(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.disName = paramString2;
  }

  public void addTag(Tag paramTag)
  {
    addChildElement(paramTag);
  }

  public Tag getTag(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((Tag)localList.get(i)).getName().equalsIgnoreCase(paramString))
        return (Tag)localList.get(i);
    return null;
  }

  public List getTags()
  {
    return a();
  }

  public void dispose()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new TagType(this);
  }

  public String getDisName()
  {
    return this.disName;
  }

  public void setDisName(String paramString)
  {
    this.disName = paramString;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.TagType
 * JD-Core Version:    0.6.0
 */