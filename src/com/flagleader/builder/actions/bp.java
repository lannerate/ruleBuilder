package com.flagleader.builder.actions;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

class bp extends MouseAdapter
{
  bp(bm parambm)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    bm.a(this.a, !bm.a(this.a));
    if (bm.a(this.a))
    {
      bm.e(this.a).setVisible(true);
      bm.f(this.a).setVisible(false);
      bm.g(this.a).setVisible(false);
      bm.h(this.a).setVisible(false);
      bm.i(this.a).setWeights(new int[] { 100 });
      bm.i(this.a).redraw();
      bm.j(this.a).redraw();
      bm.k(this.a).setMaximized(true);
    }
    else
    {
      this.a.a();
    }
    super.mouseDoubleClick(paramMouseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bp
 * JD-Core Version:    0.6.0
 */