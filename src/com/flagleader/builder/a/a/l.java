package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.b.e;
import com.flagleader.builder.a.b.z;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.r;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.h;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ToolBar;

public class l extends e
  implements IElementViewer
{
  public l(EnumTable paramEnumTable, Composite paramComposite, bu parambu)
  {
    super(paramEnumTable, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new l((EnumTable)this.c, paramComposite, this.a);
  }

  private EnumTable F()
  {
    return (EnumTable)this.c;
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.EnumTableEditor");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".EnumTableEditor") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".EnumTableEditor");
    }
    return arrayOfString;
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.EnumTableEditor");
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.EnumTableEditor");
  }

  public String getCompositeUuid()
  {
    return F().getEditUuid() + "func";
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
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof ConstantEnum))
    {
      ConstantEnum localConstantEnum = (ConstantEnum)paramIElement;
      return new String[] { localConstantEnum.getValueName(), localConstantEnum.getValueType(), localConstantEnum.getDisplayName(), localConstantEnum.getShowGroupName(), localConstantEnum.getVarValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof ConstantEnum)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected void D()
  {
    m localm = new m(this);
    if ((localm.open() == 0) && (localm.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        IBusinessObjectEditen localIBusinessObjectEditen = F().createSubEditen(localm.a());
        if (localm.c().length() > 0)
          localIBusinessObjectEditen.changeValueType(localm.c());
        if (localm.b().length() > 0)
          localIBusinessObjectEditen.setDisplayName(localm.b());
        localIBusinessObjectEditen.setVisible(true);
        K().takeSnapshot();
        localIBusinessObjectEditen.update();
        K().setModified(true);
      }
      catch (p localp)
      {
        a().getRulesManager().j().a(localm.a() + localp.getMessage());
      }
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
 * Qualified Name:     com.flagleader.builder.a.a.l
 * JD-Core Version:    0.6.0
 */