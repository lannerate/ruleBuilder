package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.b.D;
import com.flagleader.builder.a.b.e;
import com.flagleader.builder.a.b.z;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.r;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ToolBar;

public class X extends e
  implements IElementViewer
{
  public X(SheetTable paramSheetTable, Composite paramComposite, bu parambu)
  {
    super(paramSheetTable, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new X((SheetTable)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.SheetFieldView");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.SheetFieldView");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".SheetFieldView") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".SheetFieldView");
    }
    return arrayOfString;
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.SheetFieldView");
  }

  protected String[] E()
  {
    return SheetFieldModel.DATATYPES;
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
    if ((paramIElement instanceof SheetFieldModel))
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramIElement;
      return new String[] { localSheetFieldModel.getValueName(), localSheetFieldModel.getValueType(), localSheetFieldModel.getDisplayName(), localSheetFieldModel.getShowGroupName(), localSheetFieldModel.getVarValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof SheetFieldModel)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected SheetTable F()
  {
    return (SheetTable)this.c;
  }

  protected void D()
  {
    D localD = new D(this);
    if ((localD.open() == 0) && (localD.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        IBusinessObjectEditen localIBusinessObjectEditen = F().createSubEditen(localD.a());
        if (localD.c().length() > 0)
          localIBusinessObjectEditen.changeValueType(localD.c());
        if (localD.b().length() > 0)
          localIBusinessObjectEditen.setDisplayName(localD.b());
        localIBusinessObjectEditen.setVisible(true);
        K().takeSnapshot();
        localIBusinessObjectEditen.update();
        K().setModified(true);
      }
      catch (p localp)
      {
        a().getRulesManager().j().a(localD.a() + localp.getMessage());
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
 * Qualified Name:     com.flagleader.builder.a.a.X
 * JD-Core Version:    0.6.0
 */