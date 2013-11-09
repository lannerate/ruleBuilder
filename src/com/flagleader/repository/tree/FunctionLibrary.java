package com.flagleader.repository.tree;

import com.flagleader.a.B;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.MappingFunction;
import java.util.Iterator;
import java.util.List;

public class FunctionLibrary extends AbstractLibrary
{
  public static final String NAME = "FunctionLibrary";
  public static final String DISPLAYNAME = getLocalString("FunctionLibrary.text");
  public static final String COMMONNAME = getLocalString("FunctionLibrary.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("FunctionLibrary", DISPLAYNAME, DISPLAYNAME);

  public FunctionLibrary(FunctionLibrary paramFunctionLibrary)
  {
    super(paramFunctionLibrary);
  }

  public FunctionLibrary(String paramString)
  {
    super(paramString);
  }

  public FunctionLibrary()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitFunctionLibrary(this);
  }

  public IElement deepClone()
  {
    return new FunctionLibrary(this);
  }

  public static FunctionLibrary getCommonLibrary()
  {
    return new FunctionLibrary(COMMONNAME);
  }

  public IFunctionObject getVariable(String paramString)
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      Object localObject = a().get(i);
      if (((localObject instanceof IFunctionObject)) && (((IFunctionObject)localObject).getValueName().equals(paramString)))
        return (IFunctionObject)localObject;
    }
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if (((paramIElement instanceof FunctionClass)) || ((paramIElement instanceof MappingFunction)) || ((paramIElement instanceof GlobalFunction)))
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
        if ((localObject instanceof MappingFunction))
        {
          addChildElement((MappingFunction)localObject, paramInt++);
          i = 1;
        }
        else if ((localObject instanceof FunctionClass))
        {
          addChildElement((FunctionClass)localObject, paramInt++);
          i = 1;
        }
        else
        {
          if (!(localObject instanceof GlobalFunction))
            continue;
          addChildElement((GlobalFunction)localObject, paramInt++);
          i = 1;
        }
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

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof FunctionClass)) || ((paramIElement instanceof MappingFunction)) || ((paramIElement instanceof GlobalFunction));
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public FunctionClass loadClass(String paramString)
  {
    if (getEnvionment() == null)
      return null;
    B localB = null;
    try
    {
      localB = getEnvionment().getClassInfo("com.flagleader.util." + paramString);
    }
    catch (Exception localException)
    {
    }
    if (localB == null)
      try
      {
        localB = getEnvionment().getClassInfo("java.lang." + paramString);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localB = getEnvionment().getClassInfo(paramString);
      }
    FunctionClass localFunctionClass = new FunctionClass(paramString);
    addChildElement(localFunctionClass);
    localFunctionClass.setClazz(localB);
    setModified(true);
    updateViewer();
    return localFunctionClass;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    MappingFunction localMappingFunction;
    try
    {
      return loadClass(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localMappingFunction = new MappingFunction(paramString);
      localMappingFunction.setValueType(paramString);
      addChildElement(localMappingFunction);
      setModified(true);
    }
    return localMappingFunction;
  }

  public String getName()
  {
    return "FunctionLibrary";
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
 * Qualified Name:     com.flagleader.repository.tree.FunctionLibrary
 * JD-Core Version:    0.6.0
 */