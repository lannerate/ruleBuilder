package com.flagleader.builder.actions;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;

class bu extends CTabFolder2Adapter
{
  bu(bm parambm)
  {
  }

  public void maximize(CTabFolderEvent paramCTabFolderEvent)
  {
    bm.e(this.a).setVisible(false);
    bm.g(this.a).setVisible(false);
    bm.h(this.a).setVisible(true);
    bm.i(this.a).setWeights(new int[] { 0, 100 });
    bm.j(this.a).setWeights(new int[] { 0, 100 });
    bm.i(this.a).redraw();
    bm.j(this.a).redraw();
    bm.l(this.a).setMaximized(true);
    bm.b(this.a, true);
    super.maximize(paramCTabFolderEvent);
  }

  public void minimize(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.c(false);
    this.a.a();
    bm.b(this.a, false);
    super.minimize(paramCTabFolderEvent);
  }

  public void restore(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.a();
    bm.l(this.a).setMaximized(false);
    bm.b(this.a, false);
    super.restore(paramCTabFolderEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bu
 * JD-Core Version:    0.6.0
 */