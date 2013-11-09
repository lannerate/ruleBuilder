package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import java.util.Iterator;

public abstract class AbstractLibrary extends AbstractBOContainer
{
  public AbstractLibrary()
  {
  }

  public AbstractLibrary(AbstractLibrary paramAbstractLibrary)
  {
    super(paramAbstractLibrary);
  }

  public AbstractLibrary(String paramString)
  {
    super(paramString);
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if (a(paramIElement))
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
        if (!a((IElement)localObject))
          continue;
        addChildElement((IElement)localObject, paramInt++);
        i = 1;
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractLibrary
 * JD-Core Version:    0.6.0
 */