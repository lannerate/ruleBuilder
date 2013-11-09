package com.flagleader.repository.export;

import com.flagleader.engine.Property;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.io.File;
import java.util.List;

public class RspTags extends AbstractElement
{
  private File tagsFile = null;
  private static RspTags tags = null;

  public RspTags()
  {
  }

  public RspTags(RspTags paramRspTags)
  {
    super(paramRspTags);
  }

  public void addTagType(TagType paramTagType)
  {
    addChildElement(paramTagType);
  }

  public Tag getTag(String paramString)
  {
    String str1 = paramString.substring(0, paramString.indexOf("."));
    String str2 = paramString.substring(paramString.indexOf(".") + 1);
    if (getTagType(str1) != null)
      return getTagType(str1).getTag(str2);
    return null;
  }

  public TagType getTagType(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((TagType)localList.get(i)).getName().equalsIgnoreCase(paramString))
        return (TagType)localList.get(i);
    return null;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new RspTags(this);
  }

  public String getName()
  {
    return null;
  }

  public List getTagTypes()
  {
    return a();
  }

  public File getTagsFile()
  {
    if (this.tagsFile == null)
      this.tagsFile = new File(Property.getInstance().getRuleEngineClassDir(), "rsptags.xml");
    return this.tagsFile;
  }

  public void setTagsFile(File paramFile)
  {
    this.tagsFile = paramFile;
  }

  public void save()
  {
    if (getTagsFile() != null)
      new g(this.tagsFile).a(this);
  }

  public static RspTags getInstance()
  {
    if (tags == null)
      try
      {
        tags = h.a();
      }
      catch (Exception localException)
      {
        tags = new RspTags();
      }
    return tags;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.RspTags
 * JD-Core Version:    0.6.0
 */