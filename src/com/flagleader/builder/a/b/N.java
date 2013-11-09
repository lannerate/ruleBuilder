package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.excel.ExcelCellModel;
import com.flagleader.repository.excel.ExcelColModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class N extends e
  implements IElementViewer
{
  public N(ExcelXYSheetModel paramExcelXYSheetModel, Composite paramComposite, bu parambu)
  {
    super(paramExcelXYSheetModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new N((ExcelXYSheetModel)this.c, paramComposite, this.a);
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
    return ExcelCellModel.DATETYPES;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (paramIElement == null)
    {
      if ((K().canCreateEditen()) && (paramString.length() > 0))
        try
        {
          K().initUndoable();
          ExcelCellModel localExcelCellModel = F().createCellModel(paramString, "string", paramString);
          localExcelCellModel.setVisible(true);
          K().takeSnapshot();
          K().setModified(true);
          localExcelCellModel.update();
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
    if ((paramIElement instanceof ExcelCellModel))
    {
      ExcelCellModel localExcelCellModel = (ExcelCellModel)paramIElement;
      return new String[] { localExcelCellModel.getValueName(), localExcelCellModel.getValueType(), localExcelCellModel.getDisplayName(), localExcelCellModel.getShowGroupName(), localExcelCellModel.getVarValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof ExcelCellModel)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected ExcelXYSheetModel F()
  {
    return (ExcelXYSheetModel)this.c;
  }

  protected void D()
  {
    y localy = G();
    if ((localy.open() == 0) && (localy.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        ExcelColModel localExcelColModel = F().createColModel(localy.a(), localy.c(), localy.b());
        localExcelColModel.setVisible(true);
        K().takeSnapshot();
        localExcelColModel.update();
        K().setModified(true);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, localy.a() + localException.getMessage());
      }
  }

  protected void a(Menu paramMenu, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    if ((paramIBusinessObjectEditen instanceof ExcelCellModel))
    {
      MenuItem localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("addExcelField.popup", "add Sub Field"));
      localMenuItem.addListener(13, new O(this, paramIBusinessObjectEditen));
      localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("setColorFunc.popup", "Set Color"));
      localMenuItem.addListener(13, new P(this, paramIBusinessObjectEditen));
      localMenuItem = new MenuItem(paramMenu, 2);
    }
  }

  protected y G()
  {
    return new R(this);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "cell";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.N
 * JD-Core Version:    0.6.0
 */