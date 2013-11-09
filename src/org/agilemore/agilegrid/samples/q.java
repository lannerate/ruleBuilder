package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.ax;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class q extends X
{
  public q(e parame)
  {
    super(parame, true);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 == 4)
      return new k(this.b, paramObject);
    if (paramInt2 == 5)
      return new a(this.b);
    J localJ = super.a(paramInt1, paramInt2, paramObject);
    if (paramInt2 == 0)
      localJ.a(new r(this));
    return localJ;
  }

  public void a(J paramJ, G paramG)
  {
    if (paramG.d == 5)
    {
      i locali = new i((i)c(paramG.c, paramG.d));
      paramJ.c(locali);
    }
    else
    {
      super.a(paramJ, paramG);
    }
  }

  protected boolean b(G paramG)
  {
    return (paramG != null) && (paramG != G.b) && (paramG.c >= 0) && (paramG.d == 4) && (!this.b.d());
  }

  protected Composite a(Composite paramComposite)
  {
    ToolBar localToolBar = new ToolBar(paramComposite, 0);
    localToolBar.setLayoutData(new GridData(4, 16777216, true, false));
    localToolBar.setBackground(Display.getCurrent().getSystemColor(1));
    ToolItem localToolItem1 = new ToolItem(localToolBar, 8);
    localToolItem1.addSelectionListener(new s(this, localToolBar));
    localToolItem1.setImage(ax.a(q.class, "/icons/send_mail.png"));
    localToolItem1.setToolTipText("Send Mail");
    ToolItem localToolItem2 = new ToolItem(localToolBar, 8);
    localToolItem2.addSelectionListener(new t(this, localToolBar));
    localToolItem2.setImage(ax.a(q.class, "/icons/write_mail.png"));
    localToolItem2.setToolTipText("Write Mail");
    Point localPoint = localToolBar.computeSize(-1, -1);
    localToolBar.setSize(localPoint);
    return localToolBar;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.q
 * JD-Core Version:    0.6.0
 */