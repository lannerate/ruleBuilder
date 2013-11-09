package com.flagleader.builder.actions;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;

class bs extends CTabFolder2Adapter
{
  bs(bm parambm, CTabFolder paramCTabFolder)
  {
  }

  public void maximize(CTabFolderEvent paramCTabFolderEvent)
  {
    bm.e(this.a).setVisible(false);
    bm.g(this.a).setVisible(false);
    bm.f(this.a).setVisible(true);
    bm.h(this.a).setVisible(false);
    bm.i(this.a).setWeights(new int[] { 0, 0, 100 });
    bm.j(this.a).setWeights(new int[] { 100 });
    bm.i(this.a).redraw();
    this.b.setMaximized(true);
    bm.d(this.a, true);
    super.maximize(paramCTabFolderEvent);
  }

  public void minimize(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.b(false);
    this.a.a();
    bm.d(this.a, false);
    super.minimize(paramCTabFolderEvent);
  }

  public void restore(CTabFolderEvent paramCTabFolderEvent)
  {
    this.a.a();
    this.b.setMaximized(false);
    bm.d(this.a, false);
    super.restore(paramCTabFolderEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bs
 * JD-Core Version:    0.6.0
 */