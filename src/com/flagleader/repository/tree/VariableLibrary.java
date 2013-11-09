package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import java.util.Iterator;
import java.util.List;

public class VariableLibrary extends AbstractLibrary
{
  public static final String NAME = "VariableLibrary";
  public static final String DISPLAYNAME = getLocalString("VariableLibrary.text");
  public static final String COMMONNAME = getLocalString("VariableLibrary.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("VariableLibrary", DISPLAYNAME, DISPLAYNAME);

  public VariableLibrary(VariableLibrary paramVariableLibrary)
  {
    super(paramVariableLibrary);
  }

  public VariableLibrary(String paramString)
  {
    super(paramString);
  }

  public VariableLibrary()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitVariableLibrary(this);
  }

  public IElement deepClone()
  {
    return new VariableLibrary(this);
  }

  public static VariableLibrary getCommonLibrary()
  {
    return new VariableLibrary(COMMONNAME);
  }

  public TempVariable getVariable(String paramString)
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      Object localObject = a().get(i);
      if (((localObject instanceof TempVariable)) && (((TempVariable)localObject).getValueName().equals(paramString)))
        return (TempVariable)localObject;
    }
    return null;
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof TempVariable);
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    TempVariable localTempVariable = new TempVariable(paramString);
    addChildElement(localTempVariable);
    return localTempVariable;
  }

  public boolean moveVariable(IVariableObject paramIVariableObject)
  {
    if ((paramIVariableObject instanceof TempVariable))
    {
      initUndoable();
      paramIVariableObject.getParent().removeChildElement(paramIVariableObject);
      addChildElement(paramIVariableObject);
      takeSnapshot();
      setModified(true);
      return true;
    }
    TempVariable localTempVariable;
    if ((paramIVariableObject instanceof MappingVariable))
    {
      initUndoable();
      localTempVariable = new TempVariable((MappingVariable)paramIVariableObject);
      localTempVariable.setUuid(paramIVariableObject.getUuid());
      paramIVariableObject.dispose();
      addChildElement(localTempVariable);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIVariableObject instanceof SheetFieldModel))
    {
      initUndoable();
      localTempVariable = new TempVariable();
      localTempVariable.setVariableName(paramIVariableObject.getValueName());
      localTempVariable.setDisplayName(paramIVariableObject.getDisplayName());
      localTempVariable.changeValueType(paramIVariableObject.getValueType());
      localTempVariable.setVisible(paramIVariableObject.isVisible());
      localTempVariable.setUuid(paramIVariableObject.getUuid());
      paramIVariableObject.dispose();
      addChildElement(localTempVariable);
      takeSnapshot();
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof TempVariable))
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
    TempVariable localTempVariable1;
    if ((paramIElement instanceof MappingVariable))
    {
      localTempVariable1 = new TempVariable((MappingVariable)paramIElement);
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(localTempVariable1, paramInt);
      else
        addChildElement(localTempVariable1);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof IPropertyObject))
    {
      localTempVariable1 = new TempVariable((IPropertyObject)paramIElement);
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(localTempVariable1, paramInt);
      else
        addChildElement(localTempVariable1);
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
        if ((localObject instanceof TempVariable))
        {
          addChildElement((TempVariable)localObject, paramInt++);
          i = 1;
        }
        else
        {
          TempVariable localTempVariable2;
          if ((localObject instanceof MappingVariable))
          {
            localTempVariable2 = new TempVariable((MappingVariable)localObject);
            addChildElement(localTempVariable2, paramInt++);
            i = 1;
          }
          else
          {
            if (!(localObject instanceof IPropertyObject))
              continue;
            localTempVariable2 = new TempVariable((IPropertyObject)localObject);
            addChildElement(localTempVariable2, paramInt++);
            i = 1;
          }
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

  public String getName()
  {
    return "VariableLibrary";
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
 * Qualified Name:     com.flagleader.repository.tree.VariableLibrary
 * JD-Core Version:    0.6.0
 */