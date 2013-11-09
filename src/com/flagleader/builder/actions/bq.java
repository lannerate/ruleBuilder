package com.flagleader.builder.actions;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;

class bq extends CTabFolder2Adapter
{
  bq(bm parambm, CTabFolder paramCTabFolder)
  {
  }

  public void maximize(CTabFolderEvent paramCTabFolderEvent)
  {
    bm.e(this.a).setVisible(false);
    bm.g(this.a).setVisible(true);
    bm.f(this.a).setVisible(false);
    bm.h(this.a).setVisible(false);
    bm.i(this.a).setWeights(new int[] { 0, 100 });
    bm.j(this.a).setWeights(new int[] { 100 });
    bm.i(this.a).redraw();
    bm.j(this.a).redraw();
    this.b.setMaximized(true);
    bm.c(this.a, true);
    super.maximize(paramCTabFolderEvent);
  }

  public void minimize(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.a(false);
    this.a.a();
    bm.c(this.a, false);
    super.minimize(paramCTabFolderEvent);
  }

  public void restore(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.a();
    this.b.setMaximized(false);
    bm.c(this.a, false);
    super.restore(paramCTabFolderEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bq
 * JD-Core Version:    0.6.0
 */