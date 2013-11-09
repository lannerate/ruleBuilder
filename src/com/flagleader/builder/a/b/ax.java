package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.a.g;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.soap.SoapService;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class ax extends e
  implements IElementViewer
{
  public ax(SoapService paramSoapService, Composite paramComposite, bu parambu)
  {
    super(paramSoapService, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ax((SoapService)this.c, paramComposite, this.a);
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

  protected SoapService F()
  {
    return (SoapService)this.c;
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
      if ((paramIElement instanceof SoapService))
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
      if ((!(localObject instanceof IFunctionObject)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
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
      if (localIBusinessObjectEditen1.hasSubEditen())
      {
        Iterator localIterator = localIBusinessObjectEditen1.getSubEditens();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if ((!(localObject instanceof IFunctionObject)) || ((b()) && (!((IFunctionObject)localObject).isVisible())))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject;
          Item localItem = d(paramItem);
          localItem.setData(localIBusinessObjectEditen2);
          a(localItem, localIBusinessObjectEditen2);
        }
      }
      localIBusinessObjectEditen1.setObjectEditor(new ay(this, paramItem));
    }
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "func";
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
 * Qualified Name:     com.flagleader.builder.a.b.ax
 * JD-Core Version:    0.6.0
 */