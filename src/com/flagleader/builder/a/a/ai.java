package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.b.e;
import com.flagleader.builder.a.b.y;
import com.flagleader.builder.a.b.z;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.r;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ToolBar;

public class ai extends e
  implements IElementViewer
{
  public ai(SheetMap paramSheetMap, Composite paramComposite, bu parambu)
  {
    super(paramSheetMap, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ai((SheetMap)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.SheetMapFieldView");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.SheetMapFieldView");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".SheetMapFieldView") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".SheetMapFieldView");
    }
    return arrayOfString;
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.SheetMapFieldView");
  }

  protected String[] E()
  {
    return MapValue.DATATYPES;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (paramIElement == null)
    {
      if ((K().canCreateEditen()) && (paramString.length() > 0))
        try
        {
          K().initUndoable();
          IBusinessObjectEditen localIBusinessObjectEditen = K().createSubEditen(paramString);
          localIBusinessObjectEditen.setVisible(true);
          K().takeSnapshot();
          K().setModified(true);
          localIBusinessObjectEditen.update();
          return true;
        }
        catch (p localp)
        {
          a().getRulesManager().j().a(paramString + localp.getMessage());
          return false;
        }
      return true;
    }
    if ((paramInt == 4) && ((paramIElement instanceof MapValue)))
    {
      MapValue localMapValue = (MapValue)paramIElement;
      if (!localMapValue.getValue().equals(paramString))
      {
        K().initUndoable();
        localMapValue.setValue(paramString);
        K().setModified(true);
        K().takeSnapshot();
        return true;
      }
    }
    return super.a(paramIElement, paramInt, paramString);
  }

  protected int a(int paramInt, IElement paramIElement)
  {
    if ((paramIElement == null) || (K().isLocked()))
    {
      if ((paramInt == 0) && (K().canCreateEditen()))
        return 1;
    }
    else if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramIElement;
      if (paramInt == 0)
        return 1;
      if (paramInt == 2)
        return 1;
      if ((paramInt == 4) && ((paramIElement instanceof MapValue)))
        return 1;
      if ((paramInt == 1) && (localIBusinessObjectEditen.isTypeEditable()) && ((paramIElement instanceof MapValue)))
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof MapValue))
    {
      MapValue localMapValue = (MapValue)paramIElement;
      return new String[] { localMapValue.getKey(), localMapValue.getValueType(), localMapValue.getDisplayName(), localMapValue.getShowGroupName(), localMapValue.getValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof MapValue)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected SheetMap F()
  {
    return (SheetMap)this.c;
  }

  protected y G()
  {
    return new aj(this);
  }

  protected void D()
  {
    aj localaj = new aj(this);
    if ((localaj.open() == 0) && (localaj.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        MapValue localMapValue = new MapValue();
        localMapValue.setKey(localaj.a());
        localMapValue.setValueType(localaj.c());
        localMapValue.setDisplayName(localaj.b());
        localMapValue.setValue(localaj.d());
        localMapValue.setVisible(true);
        K().addChildElement(localMapValue);
        K().setModified(true);
        K().takeSnapshot();
        localMapValue.update();
        K().setModified(true);
      }
      catch (p localp)
      {
        a().getRulesManager().j().a(localaj.a() + localp.getMessage());
      }
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "field";
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
    a(paramToolBar, "import");
  }

  protected void h()
  {
    a(new z(this));
    super.h();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ai
 * JD-Core Version:    0.6.0
 */