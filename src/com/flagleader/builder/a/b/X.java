package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.excel.ExcelRowModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class X extends e
  implements IElementViewer
{
  public X(ExcelSheetModel paramExcelSheetModel, Composite paramComposite, bu parambu)
  {
    super(paramExcelSheetModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new X((ExcelSheetModel)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.ExcelFieldView");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.ExcelFieldView");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".ExcelFieldView") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".ExcelFieldView");
    }
    return arrayOfString;
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.ExcelFieldView");
  }

  protected String[] E()
  {
    return ExcelRowModel.DATETYPES;
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
          Logger.getLogger("flagleader").log(Level.SEVERE, paramString + localp.getMessage());
          return false;
        }
      return true;
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
      if ((paramInt == 0) && (localIBusinessObjectEditen.isValueEditable()))
        return 1;
      if (paramInt == 2)
        return 1;
      if ((paramInt == 1) && (localIBusinessObjectEditen.isTypeEditable()))
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof ExcelRowModel))
    {
      ExcelRowModel localExcelRowModel = (ExcelRowModel)paramIElement;
      return new String[] { localExcelRowModel.getValueName(), localExcelRowModel.getValueType(), localExcelRowModel.getDisplayName(), localExcelRowModel.getShowGroupName(), localExcelRowModel.getVarValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof ExcelRowModel)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected ExcelSheetModel F()
  {
    return (ExcelSheetModel)this.c;
  }

  protected void D()
  {
    y localy = G();
    if ((localy.open() == 0) && (localy.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        IBusinessObjectEditen localIBusinessObjectEditen = F().createSubEditen(localy.a());
        if (localy.c().length() > 0)
          localIBusinessObjectEditen.changeValueType(localy.c());
        if (localy.b().length() > 0)
          localIBusinessObjectEditen.setDisplayName(localy.b());
        localIBusinessObjectEditen.setVisible(true);
        K().takeSnapshot();
        localIBusinessObjectEditen.update();
        K().setModified(true);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, localy.a() + localException.getMessage());
      }
  }

  protected void a(Menu paramMenu, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    if ((paramIBusinessObjectEditen instanceof ExcelRowModel))
    {
      MenuItem localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("addExcelField.popup", "add Sub Field"));
      localMenuItem.addListener(13, new Y(this, paramIBusinessObjectEditen));
      localMenuItem = new MenuItem(paramMenu, 2);
    }
  }

  protected y G()
  {
    return new Z(this);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "field";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.X
 * JD-Core Version:    0.6.0
 */