package com.flagleader.repository.export;

import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class g extends XmlWriter
{
  public g(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public g(Writer paramWriter)
  {
    super(paramWriter);
  }

  public g(File paramFile)
  {
    super(paramFile);
  }

  public void a(RspTags paramRspTags)
  {
    printHeader();
    String[] arrayOfString = new String[0];
    openMarkerLn("RspTags", arrayOfString);
    for (int i = 0; i < paramRspTags.getTagTypes().size(); i++)
      a((TagType)paramRspTags.getTagTypes().get(i));
    closeMarkerLn("RspTags");
    flush();
  }

  private void a(TagType paramTagType)
  {
    String[] arrayOfString = { "name", paramTagType.getName(), "disName", paramTagType.getDisName() };
    openMarkerLn("TagType", arrayOfString);
    for (int i = 0; i < paramTagType.getTags().size(); i++)
      a((Tag)paramTagType.getTags().get(i));
    closeMarkerLn("TagType");
  }

  private void a(Tag paramTag)
  {
    String[] arrayOfString = { "name", paramTag.getName(), "disName", paramTag.getDisName() };
    openMarkerLn("Tag", arrayOfString);
    openMarkerLn("preCode");
    print(toXml(paramTag.getPreCode()));
    closeMarkerLn("preCode");
    openMarkerLn("postCode");
    print(toXml(paramTag.getPostCode()));
    closeMarkerLn("postCode");
    closeMarkerLn("Tag");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.g
 * JD-Core Version:    0.6.0
 */