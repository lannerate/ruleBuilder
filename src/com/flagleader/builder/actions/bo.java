package com.flagleader.builder.actions;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;

class bo extends CTabFolder2Adapter
{
  bo(bm parambm)
  {
  }

  public void maximize(CTabFolderEvent paramCTabFolderEvent)
  {
    bm.e(this.a).setVisible(true);
    bm.f(this.a).setVisible(false);
    bm.g(this.a).setVisible(false);
    bm.h(this.a).setVisible(false);
    bm.i(this.a).setWeights(new int[] { 100 });
    bm.i(this.a).redraw();
    bm.j(this.a).redraw();
    bm.k(this.a).setMaximized(true);
    bm.a(this.a, true);
    super.maximize(paramCTabFolderEvent);
  }

  public void minimize(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.d(false);
    this.a.a();
    bm.a(this.a, false);
    super.minimize(paramCTabFolderEvent);
  }

  public void restore(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.a();
    bm.k(this.a).setMaximized(false);
    bm.a(this.a, false);
    super.restore(paramCTabFolderEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bo
 * JD-Core Version:    0.6.0
 */