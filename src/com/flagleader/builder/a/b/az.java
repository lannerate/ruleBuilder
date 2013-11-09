package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class az extends e
  implements IElementViewer
{
  public static String[] q = c.d("rettypes.SoapParametersEditor");

  static
  {
    for (int i = 0; i < q.length; i++)
      q[i] = c.b(q[i] + ".SoapParametersEditor");
  }

  public az(SoapService paramSoapService, Composite paramComposite, bu parambu)
  {
    super(paramSoapService, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new az((SoapService)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    if (paramInt == 4)
      paramCCombo.setItems(q);
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.SoapParametersEditor");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.SoapParametersEditor");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".SoapParametersEditor") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".SoapParametersEditor");
    }
    return arrayOfString;
  }

  protected String[] E()
  {
    return SoapParameter.DATETYPES;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (paramIElement == null)
    {
      if ((K().canCreateEditen()) && (paramString.length() > 0))
        try
        {
          K().initUndoable();
          SoapParameter localSoapParameter1 = F().addParameter(paramString, "string", paramString, 1);
          localSoapParameter1.setVisible(true);
          K().takeSnapshot();
          K().setModified(true);
          localSoapParameter1.update();
          return true;
        }
        catch (p localp)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, paramString + localp.getMessage());
          return false;
        }
      return true;
    }
    if (paramInt == 4)
    {
      SoapParameter localSoapParameter2 = (SoapParameter)paramIElement;
      if ((localSoapParameter2.isTypeEditable()) && (!q[(localSoapParameter2.getRetType() - 1)].equals(paramString)))
      {
        K().initUndoable();
        for (int i = 0; i < q.length; i++)
        {
          if (!q[i].equals(paramString))
            continue;
          localSoapParameter2.setRetType(i + 1);
        }
        localSoapParameter2.getContainer().setModified(true);
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
      if ((paramInt == 0) && (localIBusinessObjectEditen.isValueEditable()))
        return 1;
      if (paramInt == 2)
        return 1;
      if ((paramInt == 1) && (localIBusinessObjectEditen.isTypeEditable()))
        return 2;
      if ((paramInt == 4) && (localIBusinessObjectEditen.isTypeEditable()))
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof SoapParameter))
    {
      SoapParameter localSoapParameter = (SoapParameter)paramIElement;
      return new String[] { localSoapParameter.getValueName(), localSoapParameter.getValueType(), localSoapParameter.getDisplayName(), q[(localSoapParameter.getRetType() - 1)], localSoapParameter.getShowGroupName() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof SoapParameter)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected SoapService F()
  {
    return (SoapService)this.c;
  }

  protected void D()
  {
    aA localaA = (aA)G();
    if ((localaA.open() == 0) && (localaA.a().length() > 0) && (F().canCreateEditen()))
      try
      {
        K().initUndoable();
        SoapParameter localSoapParameter = F().addParameter(localaA.a(), localaA.c(), localaA.b(), localaA.d());
        localSoapParameter.setVisible(true);
        K().takeSnapshot();
        localSoapParameter.update();
        K().setModified(true);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, localaA.a() + localException.getMessage());
      }
  }

  protected y G()
  {
    return new aA(this);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "props";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.az
 * JD-Core Version:    0.6.0
 */