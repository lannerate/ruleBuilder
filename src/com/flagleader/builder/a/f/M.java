package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.IRuleObject;
import org.agilemore.agilegrid.a.l;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class M extends l
{
  private Object o;

  public M(o paramo, e parame)
  {
    this(paramo, parame, null);
  }

  public M(o paramo, e parame, Object paramObject)
  {
    this(paramo, parame, 0, paramObject);
  }

  public M(o paramo, e parame, int paramInt, Object paramObject)
  {
    super(parame, paramInt);
    this.o = paramObject;
  }

  protected Control a(Composite paramComposite)
  {
    if (m() == null)
      return null;
    Display localDisplay = paramComposite.getDisplay();
    Composite localComposite1 = new Composite(paramComposite, 0);
    localComposite1.setBackground(localDisplay.getSystemColor(1));
    GridLayout localGridLayout1 = new GridLayout();
    localGridLayout1.marginHeight = 0;
    localGridLayout1.marginWidth = 0;
    localComposite1.setLayoutData(new GridData(4, 4, true, true));
    localComposite1.setLayout(localGridLayout1);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayoutData(new GridData(4, 4, true, true));
    localComposite2.setBackground(localComposite1.getBackground());
    GridLayout localGridLayout2 = new GridLayout();
    localGridLayout2.marginWidth = 0;
    localGridLayout2.marginHeight = 0;
    localGridLayout2.numColumns = 1;
    localComposite2.setLayout(localGridLayout2);
    new bl((IRuleObject)m(), localComposite2, o.f(this.a)).update();
    return localComposite1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.M
 * JD-Core Version:    0.6.0
 */