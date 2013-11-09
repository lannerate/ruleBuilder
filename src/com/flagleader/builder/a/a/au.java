package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.b.e;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.a.g;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import java.util.Iterator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class au extends e
  implements IElementViewer
{
  public au(ISelectObject paramISelectObject, Composite paramComposite, bu parambu)
  {
    super(paramISelectObject, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new au((ISelectObject)this.c, paramComposite, this.a);
  }

  protected ISelectObject F()
  {
    return (ISelectObject)this.c;
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
    else if ((paramInt == 3) && (paramIElement != null) && ((paramIElement instanceof TableFunction)))
    {
      TableFunction localTableFunction = (TableFunction)paramIElement;
      if (!localTableFunction.getGroupName().equals(paramString))
      {
        K().initUndoable();
        localTableFunction.setGroupName(paramString);
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
      if ((!(localObject instanceof IFunctionObject)) || ((b()) && (!((IFunctionObject)localObject).isVisible())))
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

  protected void a(Menu paramMenu, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    if (((paramIBusinessObjectEditen instanceof TableFunction)) && (paramIBusinessObjectEditen.getValueName().startsWith("setWhereObject(")))
    {
      MenuItem localMenuItem = new MenuItem(paramMenu, 8);
      TableFunction localTableFunction = (TableFunction)paramIBusinessObjectEditen;
      localMenuItem.setText(ResourceTools.getMessage("edit.popup", "edit"));
      localMenuItem.addListener(13, new av(this, localTableFunction));
    }
    super.a(paramMenu, paramIBusinessObjectEditen);
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
 * Qualified Name:     com.flagleader.builder.a.a.au
 * JD-Core Version:    0.6.0
 */