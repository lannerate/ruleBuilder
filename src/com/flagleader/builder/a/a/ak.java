package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.b.e;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.a.g;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import java.util.Iterator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class ak extends e
  implements IElementViewer
{
  public ak(SheetMap paramSheetMap, Composite paramComposite, bu parambu)
  {
    super(paramSheetMap, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ak((SheetMap)this.c, paramComposite, this.a);
  }

  protected SheetMap F()
  {
    return (SheetMap)this.c;
  }

  protected boolean e()
  {
    return true;
  }

  protected void D()
  {
    g localg = new g(this.b.getShell(), F().getCanCreateSubFunction());
    if (localg.open() == 0)
    {
      K().initUndoable();
      if (F().createSubFunction(localg.a()))
      {
        F().setModified(true);
        K().takeSnapshot();
        update();
      }
    }
  }

  protected int a(int paramInt, IElement paramIElement)
  {
    if ((paramIElement != null) && ((paramIElement instanceof IBusinessObjectEditen)))
    {
      if (paramInt == 2)
        return 1;
      if (paramInt == 3)
        return 1;
    }
    return 0;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (b())
      return false;
    if ((paramInt == 2) && (paramIElement != null))
    {
      if (!paramIElement.getDisplayName().equals(paramString))
      {
        K().initUndoable();
        if ((paramIElement instanceof IBOAndContainer))
        {
          ((IBOAndContainer)paramIElement).changeDisplayName(paramIElement.getDisplayName(), paramString);
          paramIElement.setDisplayName(paramString);
          K().setModified(true);
          K().takeSnapshot();
          ((IBOAndContainer)paramIElement).updateTree();
        }
        else
        {
          paramIElement.setDisplayName(paramString);
          K().setModified(true);
          K().takeSnapshot();
        }
        return true;
      }
    }
    else if ((paramInt == 3) && (paramIElement != null) && ((paramIElement instanceof IFunctionObject)))
    {
      IFunctionObject localIFunctionObject = (IFunctionObject)paramIElement;
      if (!localIFunctionObject.getGroupName().equals(paramString))
      {
        K().initUndoable();
        localIFunctionObject.setGroupName(paramString);
        K().setModified(true);
        K().takeSnapshot();
        return true;
      }
    }
    return false;
  }

  protected void t()
  {
    Iterator localIterator = F().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof IBusinessObjectEditen)) || ((localObject instanceof MapValue)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
  }

  protected void a(Item paramItem, IElement paramIElement)
  {
    super.a(paramItem, paramIElement);
    b(paramItem);
  }

  public String getCompositeUuid()
  {
    return F().getEditUuid() + "func";
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.BusinessObjectEditor");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ak
 * JD-Core Version:    0.6.0
 */