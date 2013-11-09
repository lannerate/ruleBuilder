package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NodeProperty
  implements f
{
  private String name = "";
  private String displayName = "";
  private String type = "";
  private String disType = "";
  private String defaultName = "";
  private String uuid = null;
  private List maps = new ArrayList(3);

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public String getDefaultName()
  {
    return this.defaultName;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getDisType()
  {
    return this.disType;
  }

  public Iterator getMaps()
  {
    return this.maps.iterator();
  }

  public String getName()
  {
    return this.name;
  }

  public String getType()
  {
    return this.type;
  }

  public void setDefaultName(String paramString)
  {
    this.defaultName = paramString;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public void setDisType(String paramString)
  {
    this.disType = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void addMap(AdvancedProperty paramAdvancedProperty)
  {
    this.maps.add(paramAdvancedProperty);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.NodeProperty
 * JD-Core Version:    0.6.0
 */