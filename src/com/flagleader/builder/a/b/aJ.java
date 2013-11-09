package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.Iterator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class aJ extends e
  implements IElementViewer
{
  public aJ(TreeValueNode paramTreeValueNode, Composite paramComposite, bu parambu)
  {
    super(paramTreeValueNode, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aJ((TreeValueNode)this.c, paramComposite, this.a);
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

  protected TreeValueNode F()
  {
    return (TreeValueNode)this.c;
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
    Iterator localIterator = F().getFieldIterator();
    Object localObject;
    Item localItem;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(localObject instanceof IBusinessObjectEditen)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    localIterator = F().getNodesIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(localObject instanceof TreeValueNode)) || ((b()) && (!((TreeValueNode)localObject).isVisible())))
        continue;
      localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (TreeValueNode)localObject);
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
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramIElement;
      super.a(paramItem, localIBusinessObjectEditen.isVisible(), new String[] { localIBusinessObjectEditen.getValueName(), localIBusinessObjectEditen.getValueType(), localIBusinessObjectEditen.getDisplayName(), localIBusinessObjectEditen.getShowGroupName(), localIBusinessObjectEditen.getVarValue() });
      if ((localIBusinessObjectEditen instanceof IVariableObject))
        if (((IVariableObject)localIBusinessObjectEditen).isLoged())
          a(paramItem, h.j);
        else
          a(paramItem, null);
      paramItem.setData(localIBusinessObjectEditen);
      if ((localIBusinessObjectEditen instanceof TreeValueNode))
      {
        Iterator localIterator = ((TreeValueNode)localIBusinessObjectEditen).getFieldIterator();
        Object localObject;
        Item localItem;
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((!(localObject instanceof IBusinessObjectEditen)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
            continue;
          localItem = d(paramItem);
          localItem.setData(localObject);
          a(localItem, (IBusinessObjectEditen)localObject);
        }
        localIterator = ((TreeValueNode)localIBusinessObjectEditen).getNodesIterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((!(localObject instanceof TreeValueNode)) || ((b()) && (!((TreeValueNode)localObject).isVisible())))
            continue;
          localItem = d(paramItem);
          localItem.setData(localObject);
          a(localItem, (TreeValueNode)localObject);
        }
      }
      localIBusinessObjectEditen.setObjectEditor(new aK(this, paramItem));
    }
  }

  protected int f()
  {
    return 2;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aJ
 * JD-Core Version:    0.6.0
 */