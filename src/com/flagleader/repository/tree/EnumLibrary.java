package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnumLibrary extends AbstractLibrary
{
  public static final String NAME = "EnumLibrary";
  public static final String DISPLAYNAME = getLocalString("EnumLibrary.text");
  public static final String COMMONNAME = getLocalString("EnumLibrary.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("EnumLibrary", DISPLAYNAME, DISPLAYNAME);
  public static ArrayList sysEnums = initSystemEnums();

  public EnumLibrary(EnumLibrary paramEnumLibrary)
  {
    super(paramEnumLibrary);
  }

  public EnumLibrary()
  {
  }

  public EnumLibrary(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitEnumLibrary(this);
  }

  public IElement deepClone()
  {
    return new EnumLibrary(this);
  }

  public String getName()
  {
    return "EnumLibrary";
  }

  public static EnumLibrary getCommonLibrary()
  {
    return new EnumLibrary(COMMONNAME);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof ConstantEnum);
  }

  public List getEnums(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof ConstantEnum)) || (!((ConstantEnum)localObject).isEditVisible()) || ((paramString != null) && (paramString.length() != 0) && (!((ConstantEnum)localObject).getJavaType().b(paramString))))
        continue;
      localArrayList.add(localObject);
    }
    if (paramString.equalsIgnoreCase("string"))
      localArrayList.addAll(sysEnums);
    return localArrayList;
  }

  public static ArrayList initSystemEnums()
  {
    ArrayList localArrayList = new ArrayList(6);
    localArrayList.add(new ConstantEnum("rulename", u.a("rulename.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("rulepackagename", u.a("rulepackagename.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("rulepackagedisname", u.a("rulepackagedisname.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleversion", u.a("ruleversion.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("rulemainversion", u.a("rulemainversion.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("loginuser", u.a("loginuser.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleinputparameter", u.a("ruleinputparameter.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleoutputparameter", u.a("ruleoutputparameter.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleinoutparameter", u.a("ruleinoutparameter.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("rulein", u.a("rulein.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleout", u.a("ruleout.text"), u.a("system.text")));
    localArrayList.add(new ConstantEnum("ruleinout", u.a("ruleinout.text"), u.a("system.text")));
    return localArrayList;
  }

  public Iterator getSystemEnums()
  {
    return sysEnums.iterator();
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    ConstantEnum localConstantEnum = new ConstantEnum(paramString);
    addChildElement(localConstantEnum);
    return localConstantEnum;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof ConstantEnum))
    {
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(paramIElement, paramInt);
      else
        addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      initUndoable();
      int i = 0;
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof ConstantEnum))
          continue;
        addChildElement((ConstantEnum)localObject, paramInt++);
        i = 1;
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
        return true;
      }
    }
    return false;
  }

  public String getDisplayName()
  {
    return DISPLAYNAME;
  }

  public boolean isVisible()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.EnumLibrary
 * JD-Core Version:    0.6.0
 */