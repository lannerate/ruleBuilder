package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.BOContainerGroup;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class a extends e
  implements IElementViewer
{
  public a(BOContainerGroup paramBOContainerGroup, Composite paramComposite, bu parambu)
  {
    super(paramBOContainerGroup, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new a((BOContainerGroup)this.c, paramComposite, this.a);
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
  }

  protected BOContainerGroup F()
  {
    return (BOContainerGroup)this.c;
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
      Object localObject = localIterator.next();
      if ((!(localObject instanceof IBusinessObjectEditen)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
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
      else if ((localIBusinessObjectEditen1 instanceof EnumTable))
      {
        localIterator = ((EnumTable)localIBusinessObjectEditen1).getFields().iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((!(localObject instanceof ConstantEnum)) || ((b()) && (!((ConstantEnum)localObject).isVisible())))
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
      localIBusinessObjectEditen1.setObjectEditor(new b(this, paramItem));
    }
    if (((paramIElement instanceof CustomSql)) || (b()))
      b(paramItem);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.a
 * JD-Core Version:    0.6.0
 */