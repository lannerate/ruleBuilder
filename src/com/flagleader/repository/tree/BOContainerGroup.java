package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.List;

public class BOContainerGroup extends AbstractBOContainer
{
  public static final String NAME = "BOContainerGroup";
  public static final String DISPLAYNAME = getLocalString("BOContainerGroup.text");
  public static final NodeInfo nodeInfo = new NodeInfo("BOContainerGroup", DISPLAYNAME, DISPLAYNAME);

  public BOContainerGroup(BOContainerGroup paramBOContainerGroup)
  {
    super(paramBOContainerGroup);
  }

  public BOContainerGroup()
  {
  }

  public BOContainerGroup(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitBOContainerGroup(this);
  }

  public IElement deepClone()
  {
    return new BOContainerGroup(this);
  }

  public String getName()
  {
    return "BOContainerGroup";
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return paste(paramIElement.deepClone());
  }

  public boolean paste(IElement paramIElement)
  {
    Object localObject;
    if ((paramIElement instanceof SheetTable))
    {
      localObject = (SheetTable)paramIElement;
      if (exitsTableVarName(((SheetTable)localObject).getEnglishName()))
        ((SheetTable)localObject).changeVarName(getVarTableName("sheet"));
    }
    else if ((paramIElement instanceof SheetMap))
    {
      localObject = (SheetMap)paramIElement;
      if (exitsTableVarName(((SheetMap)localObject).getEnglishName()))
        ((SheetMap)localObject).changeVarName(getVarTableName("map"));
    }
    if (super.paste(paramIElement))
    {
      updateViewer();
      return true;
    }
    return false;
  }

  public boolean exitsTableVarName(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof SheetMap))
      {
        if (((SheetMap)localList.get(i)).getEnglishName().equalsIgnoreCase(paramString))
          return true;
      }
      else if (((localList.get(i) instanceof SheetTable)) && (((SheetTable)localList.get(i)).getEnglishName().equalsIgnoreCase(paramString)))
        return true;
    return false;
  }

  public String getVarTableName(String paramString)
  {
    String str = paramString;
    int i = 0;
    while (exitsTableVarName(str))
    {
      i++;
      str = paramString + i;
    }
    return str;
  }

  public void createEnumTable(String paramString)
  {
    EnumTable localEnumTable = new EnumTable(getChildDefaultName(paramString));
    addChildElement(localEnumTable);
    setModified(true);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof SheetTable)) || ((paramITreeNode instanceof EnumTable)) || ((paramITreeNode instanceof SheetMap));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("SheetMap")) || (paramString.equals("SheetTable")) || (paramString.equals("EnumTable"));
  }

  public int getMinPos()
  {
    return 5;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.BOContainerGroup
 * JD-Core Version:    0.6.0
 */