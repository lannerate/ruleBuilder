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

public class ValueLibrary extends AbstractLibrary
{
  public static final String NAME = "ValueLibrary";
  public static final String DISPLAYNAME = getLocalString("ValueLibrary.text");
  public static final String COMMONNAME = getLocalString("ValueLibrary.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("ValueLibrary", DISPLAYNAME, DISPLAYNAME);

  public ValueLibrary(ValueLibrary paramValueLibrary)
  {
    super(paramValueLibrary);
  }

  public ValueLibrary(String paramString)
  {
    super(paramString);
  }

  public ValueLibrary()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitValueLibrary(this);
  }

  public IElement deepClone()
  {
    return new ValueLibrary(this);
  }

  public static ValueLibrary getCommonLibrary()
  {
    return new ValueLibrary(COMMONNAME);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof MappingVariable);
  }

  public MappingVariable getVariable(String paramString)
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      Object localObject = a().get(i);
      if (((localObject instanceof MappingVariable)) && (((MappingVariable)localObject).getValueName().equals(paramString)))
        return (MappingVariable)localObject;
    }
    return null;
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    MappingVariable localMappingVariable = new MappingVariable(paramString);
    addChildElement(localMappingVariable);
    return localMappingVariable;
  }

  public boolean moveVariable(IVariableObject paramIVariableObject)
  {
    if ((paramIVariableObject instanceof MappingVariable))
    {
      initUndoable();
      paramIVariableObject.getParent().removeChildElement(paramIVariableObject);
      addChildElement(paramIVariableObject);
      takeSnapshot();
      setModified(true);
      return true;
    }
    MappingVariable localMappingVariable;
    if ((paramIVariableObject instanceof TempVariable))
    {
      initUndoable();
      localMappingVariable = new MappingVariable((TempVariable)paramIVariableObject);
      localMappingVariable.setUuid(paramIVariableObject.getUuid());
      paramIVariableObject.dispose();
      addChildElement(localMappingVariable);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIVariableObject instanceof SheetFieldModel))
    {
      initUndoable();
      localMappingVariable = new MappingVariable();
      localMappingVariable.setVariableName(paramIVariableObject.getValueName());
      localMappingVariable.setDisplayName(paramIVariableObject.getDisplayName());
      localMappingVariable.changeValueType(paramIVariableObject.getValueType());
      localMappingVariable.setVisible(paramIVariableObject.isVisible());
      localMappingVariable.setUuid(paramIVariableObject.getUuid());
      paramIVariableObject.dispose();
      addChildElement(localMappingVariable);
      takeSnapshot();
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof MappingVariable))
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
    MappingVariable localMappingVariable1;
    if ((paramIElement instanceof TempVariable))
    {
      localMappingVariable1 = new MappingVariable((TempVariable)paramIElement);
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(localMappingVariable1, paramInt);
      else
        addChildElement(localMappingVariable1);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof IPropertyObject))
    {
      localMappingVariable1 = new MappingVariable((IPropertyObject)paramIElement);
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(localMappingVariable1, paramInt);
      else
        addChildElement(localMappingVariable1);
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
        if ((localObject instanceof MappingVariable))
        {
          addChildElement((MappingVariable)localObject, paramInt++);
          i = 1;
        }
        else
        {
          MappingVariable localMappingVariable2;
          if ((localObject instanceof TempVariable))
          {
            localMappingVariable2 = new MappingVariable((TempVariable)localObject);
            addChildElement(localMappingVariable2, paramInt++);
            i = 1;
          }
          else
          {
            if (!(localObject instanceof IPropertyObject))
              continue;
            localMappingVariable2 = new MappingVariable((IPropertyObject)localObject);
            addChildElement(localMappingVariable2, paramInt++);
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
    return "ValueLibrary";
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
 * Qualified Name:     com.flagleader.repository.tree.ValueLibrary
 * JD-Core Version:    0.6.0
 */