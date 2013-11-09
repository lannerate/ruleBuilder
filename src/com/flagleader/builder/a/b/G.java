package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.a.g;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class G extends e
  implements IElementViewer
{
  public G(DBModel paramDBModel, Composite paramComposite, bu parambu)
  {
    super(paramDBModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new G((DBModel)this.c, paramComposite, this.a);
  }

  protected String[] o()
  {
    return super.o();
  }

  protected String[] n()
  {
    return super.n();
  }

  protected void D()
  {
    g localg = new g(this.b.getShell(), F().getCanCreateSubFunction());
    if ((localg.open() == 0) && (localg.a().size() > 0))
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

  protected DBModel F()
  {
    return (DBModel)this.c;
  }

  protected int a(int paramInt, IElement paramIElement)
  {
    if ((paramIElement != null) && ((paramIElement instanceof IBusinessObjectEditen)) && (paramInt == 2))
      return 1;
    return 0;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (b())
      return false;
    if ((paramInt == 2) && (paramIElement != null) && (!paramIElement.getDisplayName().equals(paramString)))
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
        K().takeSnapshot();
        K().setModified(true);
      }
      return true;
    }
    return false;
  }

  protected void t()
  {
    Iterator localIterator = F().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof IBusinessObjectEditen))
      {
        if ((b()) && (!((IBusinessObjectEditen)localObject1).isVisible()))
          continue;
        localObject2 = d(null);
        ((Item)localObject2).setData(localObject1);
        a((Item)localObject2, (IBusinessObjectEditen)localObject1);
      }
      else
      {
        if (!(localObject1 instanceof CustomSql))
          continue;
        localObject2 = ((CustomSql)localObject1).getEditens();
        while (((Iterator)localObject2).hasNext())
          a(d(null), (IBusinessObjectEditen)((Iterator)localObject2).next());
      }
    }
  }

  protected boolean q()
  {
    if (b())
      return false;
    return super.q();
  }

  protected void a(Item paramItem, IElement paramIElement)
  {
    if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramIElement;
      super.a(paramItem, localIBusinessObjectEditen1.isVisible(), new String[] { localIBusinessObjectEditen1.getValueName(), localIBusinessObjectEditen1.getValueType(), localIBusinessObjectEditen1.getDisplayName(), localIBusinessObjectEditen1.getShowGroupName(), localIBusinessObjectEditen1.getVarValue() });
      if ((localIBusinessObjectEditen1 instanceof IVariableObject))
        if (((IVariableObject)localIBusinessObjectEditen1).isLoged())
          a(paramItem, h.j);
        else
          a(paramItem, null);
      paramItem.setData(localIBusinessObjectEditen1);
      Iterator localIterator;
      Object localObject;
      IBusinessObjectEditen localIBusinessObjectEditen2;
      Item localItem;
      if ((localIBusinessObjectEditen1 instanceof SheetTable))
      {
        localIterator = ((SheetTable)localIBusinessObjectEditen1).getFieldIterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((!(localObject instanceof IPropertyObject)) || ((b()) && (!((IPropertyObject)localObject).isVisible())))
            continue;
          localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject;
          localItem = d(paramItem);
          localItem.setData(localIBusinessObjectEditen2);
          a(localItem, localIBusinessObjectEditen2);
        }
      }
      else if (localIBusinessObjectEditen1.hasSubEditen())
      {
        localIterator = localIBusinessObjectEditen1.getSubEditens();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((!(localObject instanceof IFunctionObject)) || ((b()) && (!((IFunctionObject)localObject).isVisible())))
            continue;
          localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject;
          localItem = d(paramItem);
          localItem.setData(localIBusinessObjectEditen2);
          a(localItem, localIBusinessObjectEditen2);
        }
      }
      localIBusinessObjectEditen1.setObjectEditor(new H(this, paramItem));
    }
    if (((paramIElement instanceof CustomSql)) || (b()))
      b(paramItem);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.G
 * JD-Core Version:    0.6.0
 */